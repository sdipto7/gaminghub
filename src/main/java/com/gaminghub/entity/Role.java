package com.gaminghub.entity;

/**
 * @author rumi.dipto
 * @since 8/21/22
 */
public enum Role {

    ROLE_LOGIN_DELETE("Login Delete"),
    ROLE_USER_DELETE("User Delete"),
    ROLE_GAME_CREATE("Game Create"),
    ROLE_GAME_UPDATE("Game Update"),
    ROLE_GAME_DELETE("Game Delete");

    private String label;

    Role(String label) {
        this.label = label;
    }
}
