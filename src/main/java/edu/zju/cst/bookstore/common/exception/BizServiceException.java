package edu.zju.cst.bookstore.common.exception;

import edu.zju.cst.bookstore.common.api.ResponseCode;
import edu.zju.cst.bookstore.common.utils.MessageUtil;

/**
 * @author 方康华
 * @description 业务异常
 * @date 2019/10/6 21:24
 */
public class BizServiceException extends BizRuntimeException{

    public BizServiceException(String errorMessage) {
        super(MessageUtil.getMessage(errorMessage), ResponseCode.BUSINESS_ERROR);
    }
}
