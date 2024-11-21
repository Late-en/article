package com.example.article.model.exception;

import com.example.article.constant.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Late-en
 */

@Data
//可以让该异常类继承自父类的hashCode()和equals()方法
@EqualsAndHashCode(callSuper = true)
//！！！之后的编写中发现异常部分并未用到，因为这是面向用户的返回，一般不将异常给前端
public class BaseException extends RuntimeException{
    private Integer code;
    private String message;
    private boolean success = false;
    private String type = "fatal";

    public BaseException(Status status){
        //使用super才能fillInStackTrace()，追踪打印轨迹
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(Integer code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }
}
