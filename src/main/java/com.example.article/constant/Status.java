package com.example.article.constant;

import lombok.Getter;

/**
 * @author Late-en
 */

@Getter
public enum Status {
    OK(200,"success", true, "success"),
    WARNING(201, "warning", false, "warning"),
    UNKNOWN_ERROR(500,"服务器未知错误", false, "error");

    private final Integer code;
    private final String message;
    private final boolean success;
    private final String type;

    Status(Integer code, String message, boolean success, String type){
        this.code = code;
        this.message = message;
        this.success = success;
        this.type = type;
    }
}
