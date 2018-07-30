package com.cn.connext.project.framework;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by Chenghan on 2017/12/12.
 */
public class Security {
    public static String signature(String token, String timestamp, String nonce) {
        String[] parms = {token, timestamp, nonce};
        Arrays.sort(parms);

        return Security.sha1Encrypt(String.join("", parms));
    }

    public static String sha1Encrypt(String str) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-1");
        } catch (Exception ex) {
            return "";
        }

        byte[] bytes_sha1_main = str.getBytes();
        digest.update(bytes_sha1_main);
        byte[] bytes_sha1_dest = digest.digest();

        StringBuilder stringBuilder = new StringBuilder();
        for (int num : bytes_sha1_dest) {
            String hexString = Integer.toHexString(num & 0xFF);
            if (hexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hexString);
        }

        return stringBuilder.toString();
    }


}
