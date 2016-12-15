package com.lofty.longan.model.net;

/**
 * 处理自定义异常
 */
public class ApiException extends RuntimeException {

    public static final int DATA_ERROR = 1;
    public static final int INTERFACE_IS_OVERDUE = 2;

    public ApiException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(int code){
        String message = "";
        switch (code) {
            case DATA_ERROR:
                message = "数据异常";
                break;
            case INTERFACE_IS_OVERDUE:
                message = "接口过期";
                break;
            default:
                message = "未知错误";

        }
        return message;
    }
}

