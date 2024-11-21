package com.example.article.model;

import com.example.article.constant.Status;
import com.example.article.model.exception.BaseException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Late-en
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    //状态码
    private Integer code;
    //状态信息
    private String message;
    //是否成功（success or warning）
    private boolean success;
    //类型
    private String type;
    //返回数据
    private Object data;

    /**
     * 构造一个自定义的API返回
     */
    public static ApiResponse of(Integer code, String message, boolean success, String type, Object data){
        return new ApiResponse(code, message, success, type, data);
    }

    /**
     * 构造一个有状态且带数据的API返回
     */
    public static ApiResponse ofStatus(Status status, String message, Object data) {
        return of(status.getCode(), message, status.isSuccess(), status.getType(), data);
    }

    /**
     * 构造一个有状态但不带数据的API返回
     */
    public static ApiResponse ofStatus(Status status, String message) {
        return of(status.getCode(), message, status.isSuccess(), status.getType(), null);
    }

    /**
     * 构造一个正常但有message警告的返回
     */
    public static ApiResponse ofWarning(String message) {
        return ofStatus(Status.WARNING, message);
    }

    /**
     * 构造一个成功的不带数据返回
     */
    public static ApiResponse ofSuccess(String message) { return ofStatus(Status.OK, message); }

    /**
     * 构造一个成功的带数据返回
     */
    public static ApiResponse ofSuccess(String message, Object data) {
        return ofStatus(Status.OK, message, data);
    }

    /**
     * 构造一个失败的返回
     */
    public static ApiResponse ofError(String message) { return ofStatus(Status.UNKNOWN_ERROR, message); }

    /**
     * 构造一个异常且带数据的API返回
     */
    public static <T extends BaseException> ApiResponse ofException(T t, Object data) {
        return of(t.getCode(), t.getMessage(), t.isSuccess(), t.getType(), data);
    }

    /**
     * 构造一个异常且不带数据的API返回
     */
    public static <T extends BaseException> ApiResponse ofException(T t) {
        return ofException(t, null);
    }

    public static ApiResponse ofAllException(Exception t) {
        return of(501, t.getMessage(), false, "fatal", null);
    }
}

