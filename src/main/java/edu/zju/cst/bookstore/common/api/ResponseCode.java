package edu.zju.cst.bookstore.common.api;

/**
 * @author 方康华
 * @description 操作返回码
 * @date 2019/10/4 13:59
 */
public enum ResponseCode {
    OK(200, "OK"),

    CREATED(201, "Created"),

    ACCEPTED(202, "Accepted"),

    NO_CONTENT(204, "No Content"),

    BAD_REQUEST(400, "Bad Request"),

    SC_UNAUTHORIZED(401, "Unauthorized Access"),

    FORBIDDEN(403, "Forbidden"),

    RESOURCE_NOT_FOUND(404, "Resource Not Found"),

    RESOURCE_NOT_ACCEPTABLE(406, "Resource Not Acceptable"),

    REQUEST_TIMEOUT(408, "Request Timeout"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    SERVICE_UNAVAILABLE(503, "Service Unavailable"),

    DATA_ACCESS_ERROR(510, "Data Access Error"),

    NOT_SUPPORTED_ERROR(512, "Not supported Error"),

    BUSINESS_ERROR(550, "Business Error");


    private final long code;
    private final String reason;

    private ResponseCode(long code, String message) {
        this.code = code;
        this.reason = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return reason;
    }

}
