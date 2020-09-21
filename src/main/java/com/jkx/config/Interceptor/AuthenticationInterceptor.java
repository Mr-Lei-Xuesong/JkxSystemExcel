package com.jkx.config.Interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.jkx.common.annotation.TokenRequired;
import com.jkx.common.exception.LoginException;
import com.jkx.common.util.CookiesUtils;
import com.jkx.common.util.JwtUtil;
import com.jkx.common.util.PasswordEncoder;
import com.jkx.entity.User;
import com.jkx.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author lx
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    IUsersService usersService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)){
            return  true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Class<?> declaringClass = method.getDeclaringClass();
        boolean classAnnotation = declaringClass.isAnnotationPresent(TokenRequired.class);
        boolean methodAnnotation = method.isAnnotationPresent(TokenRequired.class);

        // 如果 类 和 方法上都没有 TokenRequired注解 直接通过
        if (!classAnnotation && !methodAnnotation) {
            return true;
        }

        // 从 Cookie 中取出 token
        Cookie[] cookies = request.getCookies();
        String token = CookiesUtils.get(cookies, "token");

        TokenRequired tokenRequired = classAnnotation ?
                declaringClass.getAnnotation(TokenRequired.class) :
                method.getAnnotation(TokenRequired.class);
        if (tokenRequired.required()) {
            String account;
            try {
                account = JWT.decode(token)
                        .getClaim("account").asString();
            } catch (JWTDecodeException j) {
                throw new LoginException(401,"无效token");
            }
            User user = usersService.findByAccount(account);
            if (user == null){
                throw new LoginException(401,"无效token");
            }
            try {
                if (!JwtUtil.verity(token, user.getPassword())){
                    throw new LoginException(401,"无效token");
                }
            } catch (JWTVerificationException e) {
                throw new LoginException(401,"无效token");
            }
            return true;
        }

        return true;
    }
}
