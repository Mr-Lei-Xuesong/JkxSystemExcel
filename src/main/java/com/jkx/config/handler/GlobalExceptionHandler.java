package com.jkx.config.handler;

import com.jkx.common.exception.LoginException;
import com.jkx.common.exception.RegisterException;
import com.jkx.common.util.Res;
import org.apache.http.HttpStatus;
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
        return Res.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RegisterException.class)
    @ResponseBody
    public Res RegisterExceptionHandle(RegisterException e) {
        return Res.error(e.getCode(), e.getMessage());
    }


//    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Res ExceptionHandle(RuntimeException e) {
        return Res.error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }
}
