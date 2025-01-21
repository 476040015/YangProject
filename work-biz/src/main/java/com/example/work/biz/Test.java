package com.example.work.biz;

import org.apache.commons.lang3.StringUtils;

public class Test {
    public static void main(String[] args) {
        String a = "A,    B R, ,c ,,";
        String[] roleArray = a.split("\\s*,\\s*");
        for (String role : roleArray) {
//            System.out.println("未修改[" + role + "]");
        }
//        12600kf+TX+XM+HKC+HLC+4060ti+LM+XW
        int s =1939+122+808+358+2902+133+180;
        System.out.println(s);
        for (String role : roleArray) {
            if (StringUtils.isNotBlank(role)) {
//                System.out.println("[" + role + "]");
            }
        }
    }

    public boolean test(){
        return true;
    }

}
