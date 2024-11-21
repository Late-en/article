package com.example.article.model.exception;

import com.example.article.constant.Status;
import lombok.Getter;

/**
 * 页面异常
 * @author Late-en
 */
@Getter
public class PageException extends BaseException {

    public PageException(Status status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}
