package com.jkx.common.util;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * @author lx
 */
public class Res extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Res() {
        put("code", 0);
        put("msg", "success");
        put("data", null);
    }

    public static Res error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static Res error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static Res error(int code, String msg) {
        Res res = new Res();
        res.put("code", code);
        res.put("msg", msg);
        return res;
    }

    public static Res ok(Object data) {
        Res res = new Res();
        res.put("msg", "success");
        res.put("data", data);
        return res;
    }

    public static Res ok(String msg, Object data) {
        Res res = new Res();
        res.put("msg", msg);
        res.put("data", data);
        return res;
    }

    public static Res ok(Map<String, Object> data) {
        Res res = new Res();
        res.put("data", data);
        return res;
    }

    public static Res ok() {
        return new Res();
    }

    @Override
    public Res put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
