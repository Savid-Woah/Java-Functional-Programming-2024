package com.functionalprogramming.security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_CREATE("ADMIN:CREATE"),
    ADMIN_READ("ADMIN:READ"),
    ADMIN_UPDATE("ADMIN:UPDATE"),
    ADMIN_DELETE("ADMIN:DELETE"),
    MANAGER_CREATE("MANAGER:CREATE"),
    MANAGER_READ("MANAGER:READ"),
    MANAGER_UPDATE("MANAGER:UPDATE"),
    MANAGER_DELETE("MANAGER:DELETE");

    @Getter
    private final String permission;
}