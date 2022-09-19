package com.gaminghub.dto;

import com.gaminghub.entity.UserType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author rumi.dipto
 * @since 8/22/22
 */
@Getter
@Setter
public class UserDto {

    private int id;

    private String firstName;

    private String lastName;

    private String address;

    private UserType type;
}
