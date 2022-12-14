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
    USER_TYPE_CUSTOMER("Customer");

    private String label;

    UserType(String label) {
        this.label = label;
    }

    public static UserType getUserTypeByLabel(String label) {
        for (UserType userType : values()) {
            if (userType.getLabel().equals(label)) {
                return userType;
            }
        }
        return null;
    }
}
