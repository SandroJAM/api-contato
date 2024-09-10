package com.evolution.api_contato.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class StandardError {

    @JsonFormat(pattern = "HH:mm - dd/MM/yyyy")
    private LocalDateTime timeStemp;
    private Integer status;
    private String message;
    private String path;

    public StandardError() {
    }

    public StandardError(LocalDateTime timeStemp, Integer status, String message, String path) {
        this.timeStemp = timeStemp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimeStemp() {
        return timeStemp;
    }

    public void setTimeStemp(LocalDateTime timeStemp) {
        this.timeStemp = timeStemp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
