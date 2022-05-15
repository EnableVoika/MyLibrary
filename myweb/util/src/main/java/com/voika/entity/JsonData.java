package com.voika.entity;

import lombok.Data;

@Data
public class JsonData {

    private int code;
    private String msg;
    private boolean status;
    private Object data;

    JsonData(int code,boolean status,String msg,Object data) {
        this.code = code;
        this.msg = msg;
        this.status = status;
        this.data = data;
    }
    JsonData(int code,boolean status,String msg) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public static JsonData success() {
        return new JsonData(200,true,"成功");
    }
    public static JsonData success(String msg) {
        return new JsonData(200,true,msg);
    }
    public static JsonData success(Object data) {
        return new JsonData(200,true,"成功",data);
    }
    public static JsonData success(String msg,Object data) {
        return new JsonData(200,true,msg,data);
    }
    public static JsonData success(Integer code,String msg,Object data) {
        return new JsonData(code,true,msg,data);
    }
    public static JsonData success(Integer code,String msg) {
        return new JsonData(code,true,msg);
    }
    public static JsonData success(Integer code,Object data) {
        return new JsonData(code,true,"成功",data);
    }
    public static JsonData success(Integer code) {
        return new JsonData(code,true,"成功");
    }

    public static JsonData error() {
        return new JsonData(250,false,"失败");
    }
    public static JsonData error(String msg) {
        return new JsonData(250,false,msg);
    }
    public static JsonData error(Object data) {
        return new JsonData(250,false,"失败",data);
    }
    public static JsonData error(String msg,Object data) {
        return new JsonData(250,false,msg,data);
    }
    public static JsonData error(Integer code,String msg,Object data) {
        return new JsonData(code,false,msg,data);
    }
    public static JsonData error(Integer code,String msg) {
        return new JsonData(code,false,msg);
    }
    public static JsonData error(Integer code,Object data) {
        return new JsonData(code,false,"失败",data);
    }
    public static JsonData error(Integer code) {
        return new JsonData(code,false,"失败");
    }
}
