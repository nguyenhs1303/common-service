package com.mbal.saleportal.spring_template.util;

public class StringUtils {

    public static boolean isNullOrEmptyWithTrim(String s){
        return s == null || s.trim().isEmpty();
    }
}
