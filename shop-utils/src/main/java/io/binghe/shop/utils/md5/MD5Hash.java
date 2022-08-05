package io.binghe.shop.utils.md5;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

/**
 * @author binghe
 * @version 1.0.0
 * @description 提供通用的MD5加密算法
 */
@Slf4j
public class MD5Hash {

    /**
     * MD5加密
     *
     * @param text 待加密字符串
     * @return 16进制加密字符串
     * @explain springboot自带MD5加密
     */
    @SneakyThrows(Exception.class)
    public static String encryptToMD5(String text) {
        log.debug("MD5待加密字符串：{}" + text);
        String md5 = DigestUtils.md5DigestAsHex(text.getBytes("utf-8"));
        log.debug("MD5加密结果：{}", md5);
        return md5;
    }
}
