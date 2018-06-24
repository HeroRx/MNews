package com.gzucm.mnews.mvp.model.entity;

/**
 * Created on 2018/6/23 0023 14:37.
 *
 * @author herozii
 */
public class Result<T>{

    private T data;
    private String status;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }


}
