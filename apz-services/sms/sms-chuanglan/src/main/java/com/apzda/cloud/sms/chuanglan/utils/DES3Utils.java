package com.apzda.cloud.sms.chuanglan.utils;

import cn.hutool.core.codec.Base64Encoder;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DES3Utils {

    private static final String CHARSET_NAME = "UTF-8";

    private static final String DESEDE = "DESede";

    private static final String DEFAULT_CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";

    public static String encryptBase64(String data, String key) throws Exception {
        byte[] result = encrypt(data, key);
        return Base64Encoder.encode(result);
    }

    private static byte[] encrypt(String data, String key) throws Exception {
        if (StringUtils.isBlank(key)) {
            throw new Exception("key need to exists");
        }
        byte[] byteData = data.getBytes(CHARSET_NAME);

        SecretKey secretKey = new SecretKeySpec(build3DesKey(key), DESEDE);
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(byteData);
    }

    /**
     * 3DES密钥默认长度是24位，否则会报错wrong key size，如果长度大于24位需要自动截取
     */
    private static byte[] build3DesKey(String keyStr) throws Exception {
        // 3des定长密钥
        byte[] key = new byte[24];
        byte[] temp = keyStr.getBytes();

        System.arraycopy(temp, 0, key, 0, Math.min(key.length, temp.length));
        return key;
    }

}
