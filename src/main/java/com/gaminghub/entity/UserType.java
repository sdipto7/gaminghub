package com.gaminghub.entity;

import lombok.Getter;

/**
 * @author rumi.dipto
 * @since 8/20/22
 */
@Getter
public enum UserType {

    USER_TYPE_ADMIN("Admin"),
    USER_TYPE_MANAGEMENT("Management"),
    USER_TYPE_SALES_EXECUTIVE("Sales Executive"),
    USER_TYPE_CUSTOMER("Customer");

    private String label;

    UserType(String label) {
        this.label = label;
    }
}
