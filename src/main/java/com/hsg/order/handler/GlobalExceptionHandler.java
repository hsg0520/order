package com.hsg.order.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	//IllegalArgumentException 이 발생할 경우 해당 함수 return
	@ExceptionHandler(value=Exception.class)
	public String handleArgumentException(Exception e) {
		return "<h1>"+e.getMessage() +"</h1>";
	}
}
