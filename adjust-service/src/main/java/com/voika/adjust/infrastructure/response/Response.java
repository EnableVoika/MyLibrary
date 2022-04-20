package com.voika.adjust.infrastructure.response;

public enum Response {

    SUCCESS(200,true,"请求成功"),ERROR(501,false,"请求失败");

    private int code;
    private boolean flag;
    private String msg;

    Response(int code,boolean flag,String msg){
        this.code = code;
        this.flag = flag;
        this.msg = msg;
    }

    public static JsonResponse success() {
        return new JsonResponse(SUCCESS.code,SUCCESS.flag,SUCCESS.msg);
    }
    public static JsonResponse success(String msg) {
        return new JsonResponse(SUCCESS.code,SUCCESS.flag,msg);
    }
    public static JsonResponse success(String msg,Object data) {
        return new JsonResponse(SUCCESS.code,SUCCESS.flag,msg,data);
    }
    public static JsonResponse success(int code,String msg,Object data) {
        return new JsonResponse(code,SUCCESS.flag,msg,data);
    }

    public static JsonResponse error() {
        return new JsonResponse(ERROR.code,ERROR.flag,ERROR.msg);
    }
    public static JsonResponse error(String msg) {
        return new JsonResponse(ERROR.code,ERROR.flag,msg);
    }
    public static JsonResponse error(String msg,Object data) {
        return new JsonResponse(ERROR.code,ERROR.flag,msg,data);
    }
    public static JsonResponse error(int code,String msg,Object data) {
        return new JsonResponse(code,ERROR.flag,msg,data);
    }
}
