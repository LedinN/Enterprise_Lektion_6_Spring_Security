package com.nick.enterprise_lektion_6_spring_security.authorities;

import java.util.List;

import static com.nick.enterprise_lektion_6_spring_security.authorities.UserPermissions.*;

public enum UserRole {
    GUEST(List.of(GET.getPermission())),
    USER(List.of(GET.getPermission(),POST.getPermission())),
    ADMIN(List.of(GET.getPermission(),POST.getPermission(),PUT.getPermission(),DELETE));

    <E> UserRole(List<E> permission) {
    }
}
