package com.macro.mall.common.api;

/**
 * 枚举了一些常用API操作码
 * Created by macro on 2019/4/19.
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "Success"),
    FAILED(500, "Failed"),
    VALIDATE_FAILED(404, "Xác thực thất bại"),
    UNAUTHORIZED(401, "chưa đc cấp phép"),
        FORBIDDEN(403, "Forbidden");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
