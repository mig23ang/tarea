package com.mibanco.ts.crearclientecdtdgital.utils;

public class ApplicationException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    int status;

    public ApplicationException() {
    }

    public ApplicationException(int status, String message) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
