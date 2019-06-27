package com.hobart.sample.core.utils;

public class LongUtils {
    
    public static boolean equals(Long num1,Long num2){
        if (num1 == num2){
            return true;
        }
        if (num1 == null || num2 == null){
            return false;
        }
        return num1.equals(num2);
    }

    public static void main(String[] args) {
        Long num1 = 1L;
        Long num2 = 878979879879878979L;
        
        System.out.println(String.valueOf(num1));

        System.out.println(equals(num1,num2));

    }
}
