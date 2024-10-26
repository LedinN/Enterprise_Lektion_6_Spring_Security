package com.nick.enterprise_lektion_6_spring_security.authorities;

public enum Permissions {

    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    final String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
