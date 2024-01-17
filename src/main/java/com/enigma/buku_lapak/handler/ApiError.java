package com.enigma.buku_lapak.handler;

/*
Created By IntelliJ IDEA 2022.1.3 (Community Edition)
Build #IC-221.5921.22, built on June 21, 2022
@Author JEJE a.k.a Jefri S
Java Developer
Created On 10/8/2023 01:05
@Last Modified 10/8/2023 01:05
Version 1.0
*/


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {
    private HttpStatus serverResponse;
    private int status;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private List<ApiValidationError> subErrors;
    private String errorCode;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    ApiError(HttpStatus serverResponse) {
        this();
        this.serverResponse = serverResponse;
    }

    ApiError(HttpStatus serverResponse, Throwable ex) {
        this();
        this.serverResponse = serverResponse;
        this.message = "ConstantMessage.ERROR_UNEXPECTED";
    }

    ApiError(HttpStatus serverResponse, String message, Throwable ex, String path, String errorCode) {
        this();
        this.serverResponse = serverResponse;
        this.message = message;
        this.path = path;
        this.errorCode=errorCode;
    }

    public int getStatus() {
        return serverResponse.value();
    }

    public HttpStatus getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(HttpStatus serverResponse) {
        this.serverResponse = serverResponse;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
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

    public List<ApiValidationError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<ApiValidationError> subErrors) {
        this.subErrors = subErrors;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
