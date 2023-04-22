package com.hgy.storeproject.service.ex;

/** 用户数据不存在的异常 */
public class UserWalletNotEnoughException extends ServiceException {
    public UserWalletNotEnoughException() {
        super();
    }

    public UserWalletNotEnoughException(String message) {
        super(message);
    }

    public UserWalletNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserWalletNotEnoughException(Throwable cause) {
        super(cause);
    }

    protected UserWalletNotEnoughException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
