package com.example.article.model.exception;

import com.example.article.constant.Status;
import lombok.Getter;

/**
 * @author Late-en
 */
@Getter
public class PaymentException extends BaseException {

    public PaymentException(Status status) {
        super(status);
    }

    public PaymentException(Integer code, String message) {
        super(code, message);
    }
}
