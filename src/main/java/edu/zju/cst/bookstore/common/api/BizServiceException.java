package edu.zju.cst.bookstore.common.api;

import edu.zju.cst.bookstore.common.utils.Message;

/**
 * @author 方康华
 * @description 业务异常
 * @date 2019/10/6 21:24
 */
public class BizServiceException extends BizRuntimeException{

    public BizServiceException(String errorMessage) {
        super(Message.getMessage(errorMessage), ResponseCode.BUSINESS_ERROR);
    }
}
