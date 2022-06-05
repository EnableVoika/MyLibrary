package com.voika.infrastructure;

import com.voika.infrastructure.config.StringUtil;
import lombok.Data;

@Data
public class JsonData {

    private Object data;
    private String msg;
    private int code;
    private boolean ref;

    public JsonData(int code, boolean ref, String msg, Object data) {
        this.code = code;
        this.ref = ref;
        this.msg = msg;
        this.data = data;
    }

    public static JsonData success() {
        return new JsonData(200, true, "成功", null);
    }

    public static JsonData success(String msg) {
        msg = StringUtil.isEmpty(msg) ? "成功" : msg;
        return new JsonData(200, true, msg, null);
    }

    public static JsonData success(String msg, Object data) {
        msg = StringUtil.isEmpty(msg) ? "成功" : msg;
        return new JsonData(200, true, msg, data);
    }

    public static JsonData success(Object data) {
        return new JsonData(200, true, "成功", data);
    }

    public static JsonData error() {
        return new JsonData(250, false, "失败", null);
    }

    public static JsonData error(String msg) {
        msg = StringUtil.isEmpty(msg) ? "失败" : msg;
        return new JsonData(250, false, msg, null);
    }

    public static JsonData error(String msg, Object data) {
        msg = StringUtil.isEmpty(msg) ? "失败" : msg;
        return new JsonData(250, false, msg, data);
    }

    public static JsonData error(Object data) {
        return new JsonData(250, false, "失败", data);
    }

    public static JsonData noAuth() {
        return new JsonData(5000, false, "没有权限", null);
    }

    public static JsonData noAuth(String msg) {
        msg = StringUtil.isEmpty(msg) ? "没有权限" : msg;
        return new JsonData(5000, false, msg, null);
    }

    public static JsonData noAccount() {
        return new JsonData(5001, false, "账户不存在", null);
    }

    public static JsonData noAccount(String msg) {
        msg = StringUtil.isEmpty(msg) ? "账户不存在" : msg;
        return new JsonData(5001, false, msg, null);
    }

    public static JsonData errorPwd() {
        return new JsonData(5002, false, "密码错误", null);
    }

    public static JsonData errorPwd(String msg) {
        msg = StringUtil.isEmpty(msg) ? "密码错误" : msg;
        return new JsonData(5002, false, msg, null);
    }

}
