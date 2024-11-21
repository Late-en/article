package com.example.article.model.exception;

import com.example.article.constant.Status;
import lombok.Getter;

/**
 * @author Late-en
 */
@Getter
public class JsonException extends BaseException {

    public JsonException(Status status) {
        super(status);
    }

    public JsonException(Integer code, String message) {
        super(code, message);
    }
}
