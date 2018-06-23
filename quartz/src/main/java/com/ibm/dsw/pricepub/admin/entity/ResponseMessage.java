package com.ibm.dsw.pricepub.admin.entity;

import jdk.nashorn.internal.objects.annotations.Getter;


public class ResponseMessage {

    private int returnCode;
    private String returnMessage;

    public ResponseMessage(int returnCode, String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }

    public ResponseMessage() {

    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
