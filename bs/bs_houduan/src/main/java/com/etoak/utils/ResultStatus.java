package com.etoak.utils;

public enum ResultStatus {

    SUCCESS(200,true),ERROR(401,false);

    private Integer code;
    private Boolean flag;

    ResultStatus(Integer code, Boolean flag) {
        this.code = code;
        this.flag = flag;
    }

    public static JsonResponse suc(String msg,Object data) {
        return new JsonResponse(SUCCESS.code,SUCCESS.flag,msg,data);
    }
    public static JsonResponse suc(String msg) {
        return new JsonResponse(SUCCESS.code,SUCCESS.flag,msg);
    }

    public static JsonResponse error(String msg,Object data) {
        return new JsonResponse(SUCCESS.code,SUCCESS.flag,msg,data);
    }
    public static JsonResponse error(String msg) {
        return new JsonResponse(ERROR.code,ERROR.flag,msg);
    }






}
