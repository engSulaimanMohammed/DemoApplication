package com.cl.demo.utils;

public class HelperUtils {

    public static String compare(String original, String update){
/*        if(original.equals(update)){
            return original;
        } else {
            return update;
        }*/

        return original.equals(update)? original: update;
    }

    public static Long compare(Long oldValue, Long newValue) {
        if (newValue == null) {
            return oldValue;
        }
        return newValue;
    }
}
