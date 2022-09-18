package com.gaminghub.controller;

import com.gaminghub.entity.User;
import com.gaminghub.entity.UserType;
import com.gaminghub.helper.AclHelper;
import com.gaminghub.helper.UserHelper;
import com.gaminghub.model.AuthenticationResponse;
import com.gaminghub.model.SignInRequest;
import com.gaminghub.model.SignUpRequest;
import com.gaminghub.service.CustomUserDetailsService;
import com.gaminghub.service.UserService;
import com.gaminghub.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rumi.dipto
 * @since 8/24/22
 */
@RestController
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

    @GetMapping("/")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping(value = "/SignIn", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthenticationTokenForSignIn(@RequestBody SignInRequest signInRequest) throws Exception {
        try {
            System.out.println("In here");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(signInRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping(value = "/SignUp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthenticationTokenForSignUp(@RequestBody SignUpRequest signUpRequest) throws Exception {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        User savedUser = userHelper.getSavedUserFromSignUpRequest(signUpRequest);

        aclHelper.setRoleAndCreateAclForUser(savedUser);

        return ResponseEntity.ok("User registered successfully!");
    }
}
