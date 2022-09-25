package com.gaminghub.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author rumi.dipto
 * @since 8/22/22
 */
@Getter
@Setter
public class UserDto {

    @NotNull(message = "This is required field")
    private String firstName;

    @NotNull(message = "This is required field")
    private String lastName;

    @NotNull(message = "This is required field")
    private String username;

    @NotNull(message = "This is required field")
    private String password;

    @NotNull(message = "This is required field")
    private String address;

    @NotNull(message = "This is required field")
    private String userType;
}
