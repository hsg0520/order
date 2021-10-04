package com.hsg.order.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsg.order.model.User;


//자동으로 Bean 등록이 된다 @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {
	// select * from user where username = ? 
	Optional<User> findByUsername(String username);

	User findByUsernameAndPassword(String username, String password);

}


////Select * from user where username =?;
//Optional<User> findByUsername(String username);
////JPA Naming 쿼리
////select * from user where username = ? And password = ?; 쿼리가 동작을 함
//User findByUsernameAndPassword(String username,String password);

//위에꺼랑 똑같음 
//	@Query(value = "select * from user where username = ? And password = ?")
//	User login(String username, string password);