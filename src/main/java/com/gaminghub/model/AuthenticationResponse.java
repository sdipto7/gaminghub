package com.gaminghub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author rumi.dipto
 * @since 9/18/22
 */
@Getter
@AllArgsConstructor
public class AuthenticationResponse {

    private String username;

    private Set<String> roleSet;
}
