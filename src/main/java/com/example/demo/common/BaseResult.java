package com.example.demo.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义返回结果
 * <p>Title:BaseResult</p>
 * <P>Description: </P>
 */

@Data
public class BaseResult implements  Serializable{
    // 成功状态码
    public static final int STATUS_SUCCESS = 200;
    // 失败状态码
    public static final int STATUS_FAIL = 500;

    // 状态码
    private int status;
    // 提示信息
    private String message;

    private Object data;

    // 成功 200
    public static BaseResult success() {
        return BaseResult.createResult(STATUS_SUCCESS, "成功");
    }

    // 失败 500
    public static BaseResult fail() {
        return BaseResult.createResult(STATUS_FAIL, "失败");
    }

    // 自定义提示信息
    public static BaseResult success(String message) {
        return BaseResult.createResult(STATUS_SUCCESS, message);
    }

    public static BaseResult fail(String message) {
        return BaseResult.createResult(STATUS_FAIL, message);
    }

    // 自定义失败状态码及提示信息
    public static BaseResult fail(int status, String message) {
        return BaseResult.createResult(status, message);
    }

    // 返回结果
    public static BaseResult success(String message,Object data) {
        return BaseResult.createResult(STATUS_SUCCESS, message,data);
    }

    private static BaseResult createResult(int status, String message,Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setMessage(message);
        baseResult.setStatus(status);
        baseResult.setData(data);
        return baseResult;
    }

    private static BaseResult createResult(int status, String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setMessage(message);
        baseResult.setStatus(status);
        return baseResult;
    }
}
