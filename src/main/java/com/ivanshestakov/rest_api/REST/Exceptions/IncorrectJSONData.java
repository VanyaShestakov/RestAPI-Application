package com.ivanshestakov.rest_api.REST.Exceptions;

public class IncorrectJSONData {
    private String status;
    private String info;

    public IncorrectJSONData(String info, String status) {
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
