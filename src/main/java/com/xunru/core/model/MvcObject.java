package com.xunru.core.model;

import java.util.Map;

public class MvcObject {
    String code;
    String msg;
    Map map;

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

    public MvcObject() {

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
