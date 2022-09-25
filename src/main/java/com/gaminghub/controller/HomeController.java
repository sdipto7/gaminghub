package com.gaminghub.controller;

import com.gaminghub.dto.UserDto;
import com.gaminghub.entity.User;
import com.gaminghub.helper.AclHelper;
import com.gaminghub.helper.UserHelper;
import com.gaminghub.model.AuthenticationRequest;
import com.gaminghub.model.AuthenticationResponse;
import com.gaminghub.service.CustomUserDetailsService;
import com.gaminghub.service.UserService;
import com.gaminghub.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

/**
 * @author rumi.dipto
 * @since 8/24/22
 */
@RestController
@CrossOrigin("http://localhost:3000")
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserHelper userHelper;

    @Autowired
    private AclHelper aclHelper;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthenticationTokenForLogin(@Valid @RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String accessToken = jwtUtil.generateToken(userDetails);
        ResponseCookie accessCookie = ResponseCookie.from("accessToken", accessToken).path("/").maxAge(24 * 60 * 60).httpOnly(true).build();

        Set<String> roleSet = new HashSet<>();
        userDetails.getAuthorities().stream().forEach(grantedAuthority -> roleSet.add(String.valueOf(grantedAuthority)));


        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, accessCookie.toString())
                .body(new AuthenticationResponse(authenticationRequest.getUsername(), roleSet));
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerCustomer(@Valid @RequestBody UserDto userDto) {
        if (userService.existsByUsername(userDto.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        User savedUser = userHelper.mapAndGetSavedCustomerForRegister(userDto);

        aclHelper.setRoleAndCreateAclForUser(savedUser);

        return ResponseEntity.ok("User registered successfully!");
    }
}
