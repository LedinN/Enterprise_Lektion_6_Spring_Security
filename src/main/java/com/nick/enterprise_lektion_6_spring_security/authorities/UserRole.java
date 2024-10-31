package com.nick.enterprise_lektion_6_spring_security.authorities;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

import static com.nick.enterprise_lektion_6_spring_security.authorities.UserPermissions.*;

public enum UserRole {
    GUEST(List.of(GET.getPermission())),
    USER(List.of(GET.getPermission(),POST.getPermission())),
    ADMIN(List.of(GET.getPermission(),POST.getPermission(),PUT.getPermission(),DELETE.getPermission()));

    private final List<String> permissions;

    UserRole(List<String> permission) {
        this.permissions = permission;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();

        simpleGrantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_"+ this.name()));
        simpleGrantedAuthorityList.addAll(getPermissions().stream().map(SimpleGrantedAuthority::new).toList());

        return simpleGrantedAuthorityList;
    }
}
