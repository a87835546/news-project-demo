package com.yicen.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class JSONResult implements Serializable{

    private Integer status;
    private Boolean success;
    private String msg;
    private Object data;

    public JSONResult(){}
    private JSONResult(Integer status, Boolean success, String msg,Object data){
        this.status = status;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }
    public JSONResult(Object data){
        this.data = data;
        this.msg = "success";
        this.success = true;
        this.status = 200;
    }
    public static JSONResult error(String msg){
        return new JSONResult(501,false,"error",msg);
    }

    public static JSONResult success(){
        return new JSONResult(200,true,"success",null);
    }

    public static JSONResult success(Object data){
        return new JSONResult(200,true,"success",data);
    }

    public static JSONResult success(Map map){
        return new JSONResult(200,true,"success",map);
    }

    public  static JSONResult ok(Object data){
        return new JSONResult(data);
    }
    public JSONResult(ResponseStatusEnum statusEnum){
        this.msg = statusEnum.getMsg();
        this.success = statusEnum.getSuccess();
        this.status = statusEnum.getStatus();
    }
    public static JSONResult ok(){
        return new JSONResult(ResponseStatusEnum.SUCCESS);
    }

    public static JSONResult ok(ResponseStatusEnum responseStatusEnum){
        return new JSONResult(responseStatusEnum);
    }
    public static JSONResult error(){
        return new JSONResult(ResponseStatusEnum.FAILED);
    }

    public static JSONResult error(ResponseStatusEnum statusEnum){
        return new JSONResult(statusEnum);
    }
}
