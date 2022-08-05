package io.binghe.shop.utils.passwd;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author binghe
 * @version 1.0.0
 * @description 提供密码的加密功能
 */
@Slf4j
public class PasswordUtils {

    @SneakyThrows(Exception.class)
    public static String getPassword(String text) {
        return getMD5(text);
    }

    @SneakyThrows(Exception.class)
    public static String getMD5(String str) {
        MessageDigest md = MessageDigest.getInstance("MD5");// 使用MD5算法
        byte[] md5Bytes = md.digest(str.getBytes());
        return bytesToHexString(md5Bytes);
    }

    @SneakyThrows(Exception.class)
    public static String getSHA(String str) {
        MessageDigest md = MessageDigest.getInstance("SHA-256");// 使用SHA-256算法
        byte[] shaBytes = md.digest(str.getBytes());
        return bytesToHexString(shaBytes);
    }


    @SneakyThrows({Exception.class})
    public static String bytesToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        for (byte aByte : bytes) {
            int v = aByte & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String text = "123456";
        log.info("md5加密后的字符串={}", getMD5(text));
        log.info("sha加密后的字符串={}", getSHA(text));
    }
}

