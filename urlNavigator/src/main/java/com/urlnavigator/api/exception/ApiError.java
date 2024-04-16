package com.urlnavigator.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

  private String errorCode;
  private HttpStatus status;
  private String userMessage;
  private String systemMessage;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;

  public ApiError(String errorCode, HttpStatus status, String userMessage, String systemMessage,
      LocalDateTime timestamp) {
    super();
    this.errorCode = errorCode;
    this.status = status;
    this.userMessage = userMessage;
    this.systemMessage = systemMessage;
    this.timestamp = timestamp;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public String getUserMessage() {
    return userMessage;
  }

  public void setUserMessage(String userMessage) {
    this.userMessage = userMessage;
  }

  public String getSystemMessage() {
    return systemMessage;
  }

  public void setSystemMessage(String systemMessage) {
    this.systemMessage = systemMessage;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

}
