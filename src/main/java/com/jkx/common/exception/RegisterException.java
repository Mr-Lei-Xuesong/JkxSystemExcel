package com.jkx.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 注册异常
 * @author leixuesong
 */
@Setter
@Getter
public class RegisterException extends RuntimeException {
    private Integer code;

    public RegisterException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
