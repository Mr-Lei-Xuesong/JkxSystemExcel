package com.jkx.common;


import lombok.Data;

@Data
public class DataResult {

    private int ok;
    private Object data;

    public static DataResult success(Object data) {
        return success(1, data);
    }

    private static DataResult success(int ok, Object data) {
        DataResult dataResult = new DataResult();
        dataResult.setOk(ok);
        dataResult.setData(data);
        return dataResult;
    }

    public static DataResult error() {
        return error(0);
    }

    public static DataResult error(Object data) {
        return error(0, data);
    }

    public static DataResult error(int ok, Object data) {
        DataResult dataResult = new DataResult();
        dataResult.setOk(ok);
        dataResult.setData(data);
        return dataResult;
    }


}
