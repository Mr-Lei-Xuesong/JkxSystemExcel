package com.jkx.config.Interceptor;

import com.auth0.jwt.JWT;
import com.jkx.common.annotation.Admin;
import com.jkx.common.exception.LoginException;
import com.jkx.common.util.CookiesUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 管理员拦截器
 * 拦截非管理员调用管理员接口
 * @author lx
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Value("${admins}")
    private List<String> admins;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Class<?> declaringClass = method.getDeclaringClass();
        boolean classAnnotation = declaringClass.isAnnotationPresent(Admin.class);
        boolean methodAnnotation = method.isAnnotationPresent(Admin.class);

        // 如果 类 和 方法上都没有 Admin注解 直接通过
        if (!classAnnotation && !methodAnnotation) {
            return true;
        }
        Admin admin = classAnnotation ?
                declaringClass.getAnnotation(Admin.class) :
                method.getAnnotation(Admin.class);
        if (admin.required()) {
            // 从 Cookie 中取出 token
            Cookie[] cookies = request.getCookies();
            String token = CookiesUtils.get(cookies, "token");
            String account = JWT.decode(token)
                    .getClaim("account").asString();
            if (!admins.contains(account)) {
                throw new LoginException(HttpStatus.UNAUTHORIZED,"禁止访问");
            }
        }
        return true;
    }
}
