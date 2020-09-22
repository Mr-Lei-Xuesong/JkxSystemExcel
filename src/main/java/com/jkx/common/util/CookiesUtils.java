package com.jkx.common.util;

import com.jkx.common.exception.LoginException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.Optional;

/**
 * cookies工具类
 * @author lx
 */
public class CookiesUtils {
    public static String get(Cookie[] cookies, String key) {
        String result;
        if (cookies == null) {
            throw new LoginException(HttpStatus.UNAUTHORIZED,"无效token");
        }
        Optional<Cookie> first = Arrays.stream(cookies)
                .filter(cookie -> key.equals(cookie.getName()))
                .findFirst();
        Cookie target = first.orElse(new Cookie(key,""));
        result = target.getValue();
        if (result == null) {
            throw new LoginException(HttpStatus.UNAUTHORIZED,"无效token");
        }
        return result;
    }
}
