package com.simple.dto;

public class ResponseDTO {

    private String result;

    public ResponseDTO(String result) {
        this.result = result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
