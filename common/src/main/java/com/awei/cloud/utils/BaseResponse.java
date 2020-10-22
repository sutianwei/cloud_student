package com.awei.cloud.utils;


/**
 * 封装全局返回格式
 *
 * @param <T>
 */
public class BaseResponse<T> {

    /**
     * 判断是否成功
     */
    private boolean success;

    /**
     * 状态码
     */
    private String code;

    private String msg;

    /**
     * 返回的数据
     */
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> BaseResponse<T> success(String msg) {
        BaseResponse<T> response = new BaseResponse<T>();
        response.setSuccess(true);
        response.setMsg(msg);
        response.setData(null);
        return response;
    }

    public static <T> BaseResponse<T> success(T obj, String msg) {
        BaseResponse<T> response = new BaseResponse<T>();
        response.setSuccess(true);
        response.setMsg(msg);
        response.setData(obj);
        return response;
    }

    /**
     * 处理成功返回
     *
     * @return
     */
    public static <T> BaseResponse<T> error(T obj, String msg) {
        BaseResponse<T> response = new BaseResponse<T>();
        response.setSuccess(false);
        response.setMsg(msg);
        response.setData(obj);
        return response;
    }

    /**
     * 处理异常返回
     *
     * @param msg
     * @return
     */
    public static <T> BaseResponse<T> error(String msg) {
        BaseResponse<T> response = new BaseResponse<T>();
        response.setSuccess(false);
        response.setMsg(msg);
        response.setData(null);
        return response;
    }

    /**
     * 处理警告返回
     *
     * @param msg
     * @return
     */
    public static <T> BaseResponse<T> warn(String msg) {
        BaseResponse<T> response = new BaseResponse<T>();
        response.setSuccess(false);
        response.setCode("warn");
        response.setMsg(msg);
        response.setData(null);
        return response;
    }
}
