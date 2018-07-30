package com.cn.connext.project.framework.util;

/**
 * @author : zhangpeiyu
 * @package ：cn.com.connext.ddmp.framework.util
 * @time : 2018/3/29 11:39
 */

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.util.Base64;

/**
 * 3DES（或称为Triple DES）是三重数据加密算法（TDEA，Triple Data Encryption
 * Algorithm）块密码的通称。它相当于是对每个数据块应用三次DES加密算法
 *
 * @author jianggujin
 *
 */
public class HQTripleDES {

    /**
     * CBC加密
     * @param key 密钥
     * @param keyiv IV
     * @param data 明文
     * @return Base64编码的密文
     * @throws Exception
     */
    public static String encrypts(byte[] key, byte[] keyiv, byte[] data)
            throws Exception {

        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede" + "/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(keyiv);
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] bOut = cipher.doFinal(data);
        return Base64.getEncoder().encodeToString(bOut);
    }


}