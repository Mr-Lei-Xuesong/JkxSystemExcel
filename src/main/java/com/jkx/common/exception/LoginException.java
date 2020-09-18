package com.jkx.common.exception;

import lombok.Data;

/**
 * 登录异常、token异常
 * @author lx
 */
@Data
public class LoginException extends RuntimeException{
    private Integer code;
    public LoginException(Integer code, String msg){
        super(msg);
        this.code = code;
    }
}
