package com.xunru.core.model;

import java.util.Map;

public class MvcObject {
    String code;
    String msg;
    Map map;

    /**
     * 接口调用状态：成功
     */
    public static final String STATUS_200 = "200";

    /**
     * 接口调用状态：权限不足
     */
    public static final String STATUS_303 = "303";

    /**
     * 接口调用状态：token失效
     */
    public static final String STATUS_400 = "400";

    /**
     * 接口调用状态：地址调用失败
     */
    public static final String STATUS_404 = "404";

    /**
     * 用户登录状态：没有登录
     */
    public static final String STATUS_405 = "405";

    /**
     * 用户登录状态：session超时
     */
    public static final String STATUS_406 = "406";

    /**
     * 接口调用状态：失败
     */
    public static final String STATUS_500 = "500";

    /**
     * 接口调用状态：旧密码错误
     */
    public static final String STATUS_501 = "501";

    /**
     * 接口调用状态：参数校验失败
     */
    public static final String STATUS_505 = "505";

    /**
     * 接口调用状态：帐号或密码错误
     */
    public static final String STATUS_506 = "506";

    /**
     * 接口调用状态：该帐号已存在
     */
    public static final String STATUS_600 = "600";

    /**
     * 接口调用状态：帐号不能为空
     */
    public static final String STATUS_601 = "601";

    /**
     * 接口调用状态：密码不能为空
     */
    public static final String STATUS_602 = "602";

    /**
     * 接口调用状态：该编码已存在
     */
    public static final String STATUS_603 = "603";


    /**
     * 获取状态描述
     *
     * @param status
     * @return
     */
    public static final String getStatusDesc(String status) {
        String desc = "";

        if (status.equals(STATUS_200)) {
            desc = "成功";
        }
        if (status.equals(STATUS_303)) {
            desc = "权限不足";
        }
        if (status.equals(STATUS_400)) {
            desc = "token无效";
        }
        if (status.equals(STATUS_404)) {
            desc = "地址调用失败";
        }
        if (status.equals(STATUS_405)) {
            desc = "用户没有登录";
        }
        if (status.equals(STATUS_406)) {
            desc = "用户登录超时";
        }
        if (status.equals(STATUS_500)) {
            desc = "失败";
        }
        if (status.equals(STATUS_501)) {
            desc = "旧密码错误";
        }
        if (status.equals(STATUS_505)) {
            desc = "参数校验失败！！！";
        }
        if (status.equals(STATUS_506)) {
            desc = "帐号或密码错误！！！！";
        }
        if (status.equals(STATUS_600)) {
            desc = "该帐号已存在";
        }
        if (status.equals(STATUS_601)) {
            desc = "帐号不能为空";
        }
        if (status.equals(STATUS_602)) {
            desc = "密码不能为空";
        }
        if (status.equals(STATUS_603)) {
            desc = "该编码已存在";
        }

        return desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public MvcObject(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MvcObject(String code, String msg, Map map) {
        this.code = code;
        this.msg = msg;
        this.map = map;
    }
}
