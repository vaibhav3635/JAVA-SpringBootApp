package com.luv2code.springboot.cruddemo.rest;

public class EmployeeErrorResponse {
    private String message;
    private long timeStamp;
    private int status;

    public EmployeeErrorResponse(){

    }

    public EmployeeErrorResponse(String message, long timeStamp, int status) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
