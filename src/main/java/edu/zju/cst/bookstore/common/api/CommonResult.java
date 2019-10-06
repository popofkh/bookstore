package edu.zju.cst.bookstore.common.api;

/**
 * @author 方康华
 * @description 通用返回对象
 * @date 2019/10/4 9:15
 */
public class CommonResult<T> {

    private long code;
    private String message;
    private T content;

    private CommonResult() { }

    private CommonResult(long code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     * @return 通用返回对象
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResponseCode.OK.getCode(), ResponseCode.OK.getMessage(), data);
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     * @param message 提示信息
     * @return 通用返回对象
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<>(ResponseCode.OK.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     * @return 通用返回对象
     */
    public static <T>CommonResult<T> failed(String message) {
        return new CommonResult<>(ResponseCode.NO_CONTENT.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @return
     */
    public static <T> CommonResult<T> failed() {
        return new CommonResult<>(ResponseCode.NO_CONTENT.getCode(), ResponseCode.NO_CONTENT.getMessage(), null);
    }

    /**
     * 参数验证失败返回结果
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validateFailed() {
        return new CommonResult<>(ResponseCode.NO_CONTENT.getCode(), ResponseCode.NO_CONTENT.getMessage(), null);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResponseCode.NO_CONTENT.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<>(ResponseCode.NO_CONTENT.getCode(), ResponseCode.NO_CONTENT.getMessage(), data);
    }

    /**
     * 未授权返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResponseCode.FORBIDDEN.getCode(), ResponseCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
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
