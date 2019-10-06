package edu.zju.cst.bookstore.common.utils;

import edu.zju.cst.bookstore.common.api.BizServiceException;
import edu.zju.cst.bookstore.common.api.CommonResult;
import edu.zju.cst.bookstore.common.api.ResponseCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 方康华
 * @description 全局异常处理类
 * @date 2019/10/6 22:26
 */
@ControllerAdvice
@ResponseBody
public class RuntimeExceptionHandler {

    @ExceptionHandler(BizServiceException.class)
    public CommonResult BizServiceExceptionHandler(RuntimeException exception) {
        return CommonResult.failed(ResponseCode.BUSINESS_ERROR, exception.getMessage());
    }
}
