package org.zjy.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class RestResponse<T> implements Serializable{

    private int code;

    private String msg;

    private T data;

    private long timestamp;


    public static RestResponse success(String msg) {
        return new RestResponse(0, msg, null, System.currentTimeMillis());
    }

    public static RestResponse success(String msg, Object data) {
        return new RestResponse(0, msg, data, System.currentTimeMillis());
    }

    public static RestResponse success(Object data) {
        return new RestResponse(0, null, data, System.currentTimeMillis());
    }

    public static RestResponse fail(int code) {
        return new RestResponse(code, null, null, System.currentTimeMillis());
    }

    public static RestResponse fail(int code, String msg) {
        return new RestResponse(code, msg, null, System.currentTimeMillis());
    }

}