package com.hgy.storeproject.service.ex;

/** 用户数据不存在的异常 */
public class OrderItemNotFoundException extends ServiceException {
    public OrderItemNotFoundException() {
        super();
    }

    public OrderItemNotFoundException(String message) {
        super(message);
    }

    public OrderItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderItemNotFoundException(Throwable cause) {
        super(cause);
    }

    protected OrderItemNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
