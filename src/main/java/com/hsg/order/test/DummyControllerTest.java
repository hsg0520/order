package com.hsg.order.test;


import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsg.order.model.User;
import com.hsg.order.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired
	private UserRepository userRepository;
	

	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다.";
		}
		return "삭제 완료 ";
	}
	
	@Transactional //함수 종료시에 자동 commit이 됨 
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		
		requestUser.setId(id);
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		return user;	
	}
	
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	@GetMapping("/auth/users")
	public List<User> listAuth(){
		return userRepository.findAll();
	}
	
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort="id",direction=Sort.Direction.DESC) Pageable pageable){
		Page<User> paginUser = userRepository.findAll(pageable);
		
		List<User> users = paginUser.getContent();
		return users;
	}
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//user id 가 없어 null일 경우 예외 처리 
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id: "+id);
			}
		});
		return user; 
	}
	
//	@PostMapping("/api/login")
//	public List<User> join(@RequestBody User user) {
//	//	System.out.println(id);
//	//	System.out.println(password);
//		System.out.println(user.getId());
//		System.out.println(user.getPassword());
//		return userRepository.findAll();
////		user.setRole(RoleType.ADMIN);
////		userRepository.save(user);
////		return "회원가입을 완료하였습니다.";
//	}
}
