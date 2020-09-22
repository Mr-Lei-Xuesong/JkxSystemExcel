package com.jkx.common.util;

import cn.hutool.crypto.SecureUtil;
import org.springframework.stereotype.Component;

/**
 * 密码加密
 * @author lx
 */
@Component
public class PasswordEncoder {
    public String encode(String password) {
        return  SecureUtil.md5(password);
    }
}
