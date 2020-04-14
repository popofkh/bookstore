package edu.zju.cst.bookstore.common.api;

/**
 * @author 方康华
 * @description 通用返回对象
 * @date 2019/10/4 9:15
 */
public class CommonResult<T> {

    private ResponseCode code;
    private String message;
    private T content;

    private CommonResult() { }

    private CommonResult(ResponseCode code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    /**
     * 成功返回结果
     * @param content 获取的数据
     * @return 通用返回对象
     */
    public static <T> CommonResult<T> success(T content) {
        return new CommonResult<>(ResponseCode.OK, ResponseCode.OK.getMessage(), content);
    }

    /**
     * 成功返回结果
     * @param content 获取的数据
     * @param message 提示信息
     * @return 通用返回对象
     */
    public static <T> CommonResult<T> success(ResponseCode code, String message, T content) {
        return new CommonResult<>(code, message, content);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     * @return 通用返回对象
     */
    public static <T>CommonResult<T> failed(ResponseCode code, String message) {
        return new CommonResult<>(code, message, null);
    }

    public ResponseCode getCode() {
        return code;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
