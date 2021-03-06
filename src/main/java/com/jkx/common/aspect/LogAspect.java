package com.jkx.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 日志
 * @author lei
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.jkx.controller.*.*(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void logRequestInfo(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String type = request.getMethod();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, type, classMethod, args);
        log.info("Request : {}", requestLog);
    }

    @AfterReturning(returning = "result", pointcut = "pointCut()")
    public void doAfterReturn(Object result) {
        log.info("Result : {}", result);
    }

    private static class RequestLog {
        private final String url;
        private final String ip;
        private final String type;
        private final String classMethod;
        private final Object[] args;

        public RequestLog(String url, String ip, String type, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.type = type;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", type='" + type + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
