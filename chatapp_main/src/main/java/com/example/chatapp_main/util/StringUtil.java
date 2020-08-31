package com.example.chatapp_main.util;

import java.util.UUID;

public class StringUtil {

    /**
     * 产生一个32位的GUID
     * @return
     */
    public static String newGUID()
    {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
