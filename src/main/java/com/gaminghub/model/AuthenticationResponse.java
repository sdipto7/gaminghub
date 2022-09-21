package com.gaminghub.model;

import lombok.Getter;

/**
 * @author rumi.dipto
 * @since 9/18/22
 */
@Getter
public class AuthenticationResponse {

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
}
