package com.feng.dto;

/**
 * 封装json结果
 * Created by TTfly on 2017/6/11.
 */
public class SeckillResult<T> {

    private boolean isSuccess;

    private T date;

    private String error;

    public SeckillResult(boolean isSuccess, T date) {
        this.isSuccess = isSuccess;
        this.date = date;
    }

    public SeckillResult(boolean isSuccess, String error) {
        this.isSuccess = isSuccess;
        this.error = error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
