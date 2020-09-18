package com.jkx.config.handler;

import com.jkx.common.exception.LoginException;
import com.jkx.common.util.Res;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 * @author lx
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LoginException.class)
    @ResponseBody
    public Res handleException(LoginException exception) {
        return Res.error(exception.getCode(),exception.getMessage());
    }
}
