package cn.edu.swpu.cins.dto;

import cn.edu.swpu.cins.enums.ExcepMsg;

/**
 * Created by melo on 16-6-5.
 * 封装json数据
 */
public class ResultData<T> {

    /*返回数据*/
    private T data;

    /*请求结果*/
    private boolean success;
    private String errorMsg;

    public ResultData(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public ResultData(boolean success, String errorMsg) {
        this.success = success;
        this.errorMsg = errorMsg;
    }

    public ResultData(boolean success, ExcepMsg msg) {
        this.success = success;
        this.errorMsg = msg.getMsg();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
