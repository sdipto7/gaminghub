package com.gaminghub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author rumi.dipto
 * @since 9/18/22
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {

    private String username;

    private String password;
}
