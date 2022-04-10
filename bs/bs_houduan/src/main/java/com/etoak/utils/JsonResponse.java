package com.etoak.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class JsonResponse {

    private Integer code;
    private Boolean flag;
    private String msg;
    private Object data;

    public JsonResponse(Integer code, Boolean flag, String msg, Object data) {
        this.code = code;
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public JsonResponse(Integer code, Boolean flag, String msg) {
        this.code = code;
        this.flag = flag;
        this.msg = msg;
    }

    public JsonResponse() {
    }
}
