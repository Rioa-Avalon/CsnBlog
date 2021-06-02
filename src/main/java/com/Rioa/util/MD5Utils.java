package com.Rioa.util;

import org.springframework.util.DigestUtils;

public class MD5Utils {
    static final String TARGET = "admin";


    public static void main(String[] args) {
        String str = DigestUtils.md5DigestAsHex(TARGET.getBytes());
        System.out.println("md5Hex:     "+str);
    }
}
