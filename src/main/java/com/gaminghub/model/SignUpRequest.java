package com.gaminghub.model;

import com.gaminghub.entity.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author rumi.dipto
 * @since 9/21/22
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String address;

    private String userType;
}
