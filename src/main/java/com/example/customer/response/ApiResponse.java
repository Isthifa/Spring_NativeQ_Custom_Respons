package com.example.customer.response;

import org.springframework.http.HttpStatusCode;

public class ApiResponse {
    private boolean result;
    private String message;

    public ApiResponse(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public ApiResponse(String message) {
        this.message = message;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
