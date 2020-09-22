package com.jkx.config.handler;

import com.jkx.common.exception.LoginException;
import com.jkx.common.util.Res;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * @author lx
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoginException.class)
    @ResponseBody
    public Res loginExceptionHandle(LoginException e) {
        return Res.error(e.getCode().value(),e.getMessage());
    }

}
