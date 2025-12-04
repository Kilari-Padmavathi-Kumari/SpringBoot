package com.sbrestcontroller.hello.restcontroller;

public class StudentErrorResponse
{
    private int status;

    private String message;

    private long timeStamp;

    public StudentErrorResponse()
    {

    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public StudentErrorResponse(int status, String message, long timeStamp) {
        this.status=status;
        this.message = message;
        this.timeStamp=timeStamp;


    }
}
