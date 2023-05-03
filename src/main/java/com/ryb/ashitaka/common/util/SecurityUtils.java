package com.ryb.ashitaka.common.util;

import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtils {

    public static String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}