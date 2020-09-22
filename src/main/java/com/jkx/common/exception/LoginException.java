package com.jkx.common.exception;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * 登录异常、token异常
 * @author lx
 */
@Getter
@Setter
public class LoginException extends RuntimeException{
    private HttpStatus code ;

    public LoginException(HttpStatus code, String msg){
        super(msg);
        this.code = code;
    }
}
