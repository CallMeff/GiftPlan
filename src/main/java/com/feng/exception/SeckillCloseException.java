package com.feng.exception;

/**
 * 秒杀关闭异常
 * Created by TTfly on 2017/6/11.
 */
public class SeckillCloseException  extends  SeckillException{

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
