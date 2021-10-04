package com.hsg.order.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsg.order.dto.ResponseDto;
import com.hsg.order.model.User;
import com.hsg.order.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/registrations")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiContoller: save 호출됨");
		
		userService.register(user);
		
		return new ResponseDto<Integer>(HttpStatus.OK,1);
	}
	
	
	@PostMapping("/api/login")
	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
//		System.out.println("UserApiController: login 호출됨");
//		
//		User principal = userService.login(user); //principal 접근 주체
//		
//		//session이 생섬됨
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		
		return new ResponseDto<Integer>(HttpStatus.OK,1);
	}
}
