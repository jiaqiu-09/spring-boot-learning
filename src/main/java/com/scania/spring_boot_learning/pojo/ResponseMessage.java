package com.scania.spring_boot_learning.pojo;

import org.springframework.http.HttpStatus;

public class ResponseMessage<T> {
    private String message;
    private Integer code;
    private String error;
    private T data;

    public ResponseMessage(String message, Integer code, String error, T data) {
        this.message = message;
        this.code = code;
        this.error = error;
        this.data = data;
    }

    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<>("success", HttpStatus.OK.value(), null, data);
    }

    public static <T> ResponseMessage<T> error(String message, String error) {
        return new ResponseMessage<>(message, HttpStatus.SERVICE_UNAVAILABLE.value(), error, null);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
