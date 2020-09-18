package com.jkx.common.util;

import cn.hutool.crypto.SecureUtil;

/**
 * 密码加密
 * @author lx
 */
public class PasswordEncoder {
    public String encode(String password) {
        return  SecureUtil.md5(password);
    }
}
