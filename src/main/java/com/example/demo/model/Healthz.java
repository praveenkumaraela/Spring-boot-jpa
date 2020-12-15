package com.example.demo.model;

public class Healthz {

    private String status = "ok";
    private String message = "Success";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Healthz(String status, String message) {
        this.status = status;
        this.message = message;
    }


}
