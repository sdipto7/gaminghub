package com.gaminghub.entity;

import lombok.Getter;

/**
 * @author rumi.dipto
 * @since 8/21/22
 */
@Getter
public enum Role {

   ROLE_DASHBOARD_VIEW("Dashboard View"),

    ROLE_ADMIN_VIEW("Admin View"),
    ROLE_ADMIN_CREATE("Admin Create"),
    ROLE_ADMIN_UPDATE("Admin Update"),
    ROLE_ADMIN_DELETE("Admin Delete"),

    ROLE_MANAGEMENT_VIEW("Management View"),
    ROLE_MANAGEMENT_CREATE("Management Create"),
    ROLE_MANAGEMENT_UPDATE("Management Update"),
    ROLE_MANAGEMENT_DELETE("Management Delete"),

    ROLE_CUSTOMER_VIEW("Customer View"),
    ROLE_CUSTOMER_CREATE("Customer Create"),
    ROLE_CUSTOMER_UPDATE("Customer Update"),
    ROLE_CUSTOMER_DELETE("Customer Delete"),

    ROLE_GAME_VIEW("Game View"),
    ROLE_GAME_CREATE("Game Create"),
    ROLE_GAME_UPDATE("Game Update"),
    ROLE_GAME_DELETE("Game Delete"),

    ROLE_ORDER_VIEW("Order View"),
    ROLE_ORDER_CREATE("Order Create"),
    ROLE_ORDER_UPDATE("Order Update"),
    ROLE_ORDER_DELETE("Order Delete");

    private String label;

    Role(String label) {
        this.label = label;
    }
}
