package com.gaminghub.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * @author rumi.dipto
 * @since 8/21/22
 */
@Getter
@Setter
@Entity
@Table(name = "gh_acl")
public class Acl extends Persistent {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SELECT)
    @JoinColumn(name = "user_id")
    private User user;

    private Role role;
}
