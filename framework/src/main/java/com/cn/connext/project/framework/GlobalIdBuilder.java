package com.cn.connext.project.framework;

import java.util.UUID;

public class GlobalIdBuilder {
    private final static String EMPTY_UUID = "00000000-0000-0000-0000-000000000000";

    public static String newUUID() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    public static String emptyUUID() {
        return EMPTY_UUID;
    }
}
