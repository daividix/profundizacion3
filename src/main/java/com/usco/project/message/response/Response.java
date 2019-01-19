package com.usco.project.message.response;

import java.util.List;

/**
 * Response
 */
public class Response {

    private Boolean isOk;

    private String error;

    private Object result;

    private List<?> results;

    private String message;

    public Response(Boolean isOk, String message) {
        this.isOk = isOk;
        this.message = message;
    }

    public Response() {

    }

    public Boolean isIsOk() {
        return this.isOk;
    }

    public Boolean getIsOk() {
        return this.isOk;
    }

    public void setIsOk(Boolean isOk) {
        this.isOk = isOk;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public Object getResult() {
        return this.result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public List<?> getResults() {
        return this.results;
    }

    public void setResults(List<?> results) {
        this.results = results;
    }


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}