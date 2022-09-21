package com.gaminghub.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author rumi.dipto
 * @since 8/20/22
 */
@Getter
@Setter
@Entity
@Table(name = "gh_user")
public class User extends Persistent {

    private static final long serialVersionUID = 1L;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "activated")
    private boolean activated;
}
