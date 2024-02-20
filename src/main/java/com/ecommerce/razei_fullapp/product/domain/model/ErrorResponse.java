package com.ecommerce.razei_fullapp.product.domain.model;

public class ErrorResponse {

    private String error;
    private Object data;
    private Number code;

    public ErrorResponse() {
    }

    public ErrorResponse(String error, Object data, Number code) {
        this.error = error;
        this.data = data;
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Number getCode() {
        return code;
    }

    public void setCode(Number code) {
        this.code = code;
    }
}
