package com.gaminghub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author rumi.dipto
 * @since 9/18/22
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {

    @NotNull(message = "This is required field")
    private String username;

    @NotNull(message = "This is required field")
    private String password;
}
