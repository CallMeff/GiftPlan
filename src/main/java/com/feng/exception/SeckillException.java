package com.feng.exception;

/**
 * 秒杀相关业务异常
 * Created by TTfly on 2017/6/11.
 */
public class SeckillException  extends  RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
