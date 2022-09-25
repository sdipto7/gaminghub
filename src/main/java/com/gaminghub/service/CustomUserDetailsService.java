package com.gaminghub.service;

import com.gaminghub.entity.Role;
import com.gaminghub.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

/**
 * @author rumi.dipto
 * @since 9/20/22
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private AclService aclService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (isNull(user)) {
            throw new UsernameNotFoundException(username);
        }

        Set<Role> roleSet = aclService.findAllByUser(user).stream()
                .map(acl -> acl.getRole())
                .collect(Collectors.toSet());

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(getGrantedAuthorityListFromRoleSet(roleSet))
                .build();

        return userDetails;
    }

    private List<GrantedAuthority> getGrantedAuthorityListFromRoleSet(Set<Role> roleSet) {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        roleSet.stream().forEach(role -> grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getLabel())));

        return new ArrayList<>(grantedAuthoritySet);
    }
}
