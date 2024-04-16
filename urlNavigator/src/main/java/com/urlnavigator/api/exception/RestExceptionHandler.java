package com.urlnavigator.api.exception;

import java.time.LocalDateTime;

import java.util.logging.Logger;

import java.util.logging.Level;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  
  private static final Logger logger = Logger.getLogger(RestExceptionHandler.class.getName());

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
	  
	  logger.log(Level.SEVERE, "An internal error has occurred: " + e.getMessage(), e);

      if (e.getMessage().contains("Required request body is missing")) {
          ApiError apiError = new ApiError(ApiErrorMessages.PARAMETERS_ARE_REQUIRED, HttpStatus.BAD_REQUEST,
                  ApiErrorMessages.PARAMETERS_ARE_REQUIRED, ApiErrorMessages.PARAMETERS_ARE_REQUIRED, LocalDateTime.now());
          return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
      }

      ApiError apiError = new ApiError(ApiErrorCodes.UNEXPECTED_GENERAL_ERROR_CODE, HttpStatus.INTERNAL_SERVER_ERROR,
              ApiErrorCodes.UNEXPECTED_GENERAL_ERROR_CODE, e.getMessage(), LocalDateTime.now());
      return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
	  
  }
}
