package com.his.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class DcExceptionHandler {
	
	// DC Custom Exception
	@ExceptionHandler(value=DcException.class)
	public ResponseEntity<DcApiError> handleEdException(DcException e) {
		DcApiError apiError=new DcApiError("DC-API-04", e.getMessage(), new Date());
		return new ResponseEntity<DcApiError>(apiError,HttpStatus.BAD_REQUEST);
	};
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<DcApiError> handleException(Exception e) {
		DcApiError apiError=new DcApiError("DC-API-04", e.getMessage(), new Date());
		return new ResponseEntity<DcApiError>(apiError,HttpStatus.BAD_REQUEST);
	};

}
