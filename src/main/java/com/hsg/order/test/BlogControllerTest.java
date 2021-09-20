package com.hsg.order.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogControllerTest {
 
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = new Member(1,"ssar","1234", "email");
		
		return "lombok test";
	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return m.getUsername();
	}
	
	@PostMapping("http/post")
	public String postTest() {
		return "post 요청";
	}
	
	@PutMapping("http/put")
	public String putTest() {
		return "put 요청";
	}
	
	@DeleteMapping("http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
