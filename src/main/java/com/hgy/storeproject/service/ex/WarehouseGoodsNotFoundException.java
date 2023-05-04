package com.hgy.storeproject.service.ex;

/** 仓库装备不存在的异常 */
public class WarehouseGoodsNotFoundException extends ServiceException {
    public WarehouseGoodsNotFoundException() {
        super();
    }

    public WarehouseGoodsNotFoundException(String message) {
        super(message);
    }

    public WarehouseGoodsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WarehouseGoodsNotFoundException(Throwable cause) {
        super(cause);
    }

    protected WarehouseGoodsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
