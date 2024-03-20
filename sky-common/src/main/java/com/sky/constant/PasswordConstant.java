package com.sky.constant;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 密码常量
 */
public class PasswordConstant {

    public static final String DEFAULT_PASSWORD = "123456";

    /**
     * 计算默认密码的加密后密码的static方法
     * @return
     */
    public static String DEFAULT_SECRETPASSWORD(){
        MessageDigest messageDigest= null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(DEFAULT_PASSWORD.getBytes());
            byte[] result=messageDigest.digest();
            return new HexBinaryAdapter().marshal(result);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
