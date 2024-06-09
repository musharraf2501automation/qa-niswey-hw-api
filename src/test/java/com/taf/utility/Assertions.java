package com.taf.utility;

import org.junit.Assert;

public class Assertions {

    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(message, condition);
    }

    public static void assertEquals(int actual, int expected, String message) {
        Assert.assertEquals(message, expected, actual);
    }

    public static void assertEquals(String actual, String expected, String message) {
        Assert.assertEquals(message, expected, actual);
    }

    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(message, condition);
    }

    public static void assertEquals(String expected,String actual) {
        Assert.assertEquals(expected, actual);
    }

    public static void assertTrue(boolean condition) { Assert.assertTrue(condition);}
}
