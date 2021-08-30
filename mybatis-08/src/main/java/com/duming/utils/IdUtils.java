package com.duming.utils;

import org.junit.Test;

import java.util.UUID;

public class IdUtils {
    public static String  getId(){
        return UUID.randomUUID().toString().replace("-", "");
    }
    @Test
    public void test(){
        System.out.println(getId());
    }
}
