package com.ssafy.raid.auth.service.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptUtils {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String bcrypt(String origin) {
        return encoder.encode(origin);
    }
}