package com.ivanshestakov.rest_api.rest.exceptions;

public class ExceptionInfo {
    private String status;
    private String info;

    public ExceptionInfo(String info, String status) {
        this.info = info;
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
