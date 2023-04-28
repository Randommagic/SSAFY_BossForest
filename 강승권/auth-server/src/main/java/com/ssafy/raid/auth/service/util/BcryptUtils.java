package com.ssafy.raid.auth.service.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class BcryptUtils {

    public static String bcrypt(String origin) {
    	return BCrypt.withDefaults().hashToString(12, origin.toCharArray());
    }
    
    public static boolean match(String rawPassword, String encodedPassword) {
    	return BCrypt.verifyer().verify(rawPassword.toCharArray(), encodedPassword).verified;
    }
}