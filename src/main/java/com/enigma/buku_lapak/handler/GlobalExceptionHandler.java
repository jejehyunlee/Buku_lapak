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



import com.enigma.buku_lapak.config.LoggingConfig;
import com.enigma.buku_lapak.utils.LoggingFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j(topic = "GLOBAL_EXCEPTION_HANDLER")
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private List<ApiValidationError> lsSubError = new ArrayList<ApiValidationError>();
	private String[] strException = new String[2];

	public GlobalExceptionHandler() {
		strException[0] = "GlobalExceptionHandler";
	}

	@Override
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																  HttpHeaders headers,
																  HttpStatus status,
																  WebRequest request) {
		lsSubError.clear();
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			lsSubError.add(new ApiValidationError(fieldError.getField(),fieldError.getDefaultMessage(),fieldError.getRejectedValue(),fieldError.getObjectName()));
		}

		ApiError apiError =
				new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, "ConstantMessage.ERROR_UNPROCCESSABLE",ex,request.getDescription(false),"00001");
		apiError.setSubErrors(lsSubError);
		return ResponseEntity.unprocessableEntity().body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		strException[1]= "handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) -- LINE 54";
		LoggingFile.exceptionStringz(strException,ex, LoggingConfig.getFlagLogging());
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, "ConstantMessage.ERROR_MAIL_FORM_JSON", ex,request.getDescription(false),"00002"));
	}


	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		strException[1]= "resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) -- LINE 59";
		LoggingFile.exceptionStringz(strException,ex, LoggingConfig.getFlagLogging());
		return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND,ex.getMessage(),ex,request.getDescription(false),"00003"));
	}


	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleAllUncaughtException(Exception ex, WebRequest request) {

		strException[1]= "handleAllUncaughtException(Exception ex, WebRequest request) -- LINE 70";
		LoggingFile.exceptionStringz(strException,ex, LoggingConfig.getFlagLogging());
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,"ConstantMessage.ERROR_INTERNAL_SERVER",ex,request.getDescription(false),"X2013"));
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> dataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {


		strException[1]= "dataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) -- LINE 79";
		LoggingFile.exceptionStringz(strException,ex, LoggingConfig.getFlagLogging());
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST,"ConstantMessage.ERROR_DATA_INVALID",ex,request.getDescription(false),"X7006"));
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return ResponseEntity.status(apiError.getStatus()).body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		strException[1]= "handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) -- LINE 89";
		LoggingFile.exceptionStringz(strException,ex, LoggingConfig.getFlagLogging());
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,"ERROR_UNEXPECTED",ex,request.getDescription(false),"X2236"));
	}
}