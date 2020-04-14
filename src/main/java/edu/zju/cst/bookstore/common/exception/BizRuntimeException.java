package edu.zju.cst.bookstore.common.exception;

import edu.zju.cst.bookstore.common.api.ResponseCode;

/**
 * @author 方康华
 * @description 自定义异常类
 * @date 2019/10/6 9:38
 */
public class BizRuntimeException extends RuntimeException {

    private final ResponseCode code;

    public BizRuntimeException(String message, ResponseCode code) {
        super(message);
        this.code = code;
    }

    public ResponseCode getCode() {
        return code;
    }

}
