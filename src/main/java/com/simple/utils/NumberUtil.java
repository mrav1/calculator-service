package com.simple.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class NumberUtil {

    private static Pattern NUMERIC_PATTERN = Pattern.compile("[+-]?(([0-9]+\\.?[0-9]*)|([0-9]*\\.?[0-9]+))(e[+-]?[0-9]+)?");

    public static boolean isNumeric(String value) {
        if (!StringUtils.hasText(value)) {
            return false;
        }
        return NUMERIC_PATTERN.matcher(value).matches();
    }

}
