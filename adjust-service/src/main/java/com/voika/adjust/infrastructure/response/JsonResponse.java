package com.voika.adjust.infrastructure.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResponse {

    private int code;
    private boolean flag;
    private String msg;
    private Object data;

    JsonResponse(int code,boolean flag,String msg) {
        this.code = code;
        this.flag = flag;
        this.msg = msg;
    }



}
