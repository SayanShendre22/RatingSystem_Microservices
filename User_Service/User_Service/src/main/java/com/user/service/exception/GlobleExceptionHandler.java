package com.user.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.service.entity.user;
import com.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobleExceptionHandler {
	
	@ExceptionHandler(ResourseNotFoundExcepton.class)
	public ResponseEntity<ApiResponse> handleResourseNotFoundExcepton(ResourseNotFoundExcepton ex){
		String msg = ex.getMessage();
		ApiResponse response = new ApiResponse(msg,true,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}

}
