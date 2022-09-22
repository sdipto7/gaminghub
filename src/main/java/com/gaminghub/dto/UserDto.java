package com.gaminghub.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rumi.dipto
 * @since 8/22/22
 */
@Getter
@Setter
public class UserDto {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String address;

    private String userType;
}
