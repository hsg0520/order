package com.hsg.order.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hsg.order.model.User;
import com.hsg.order.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	
	// 스프링이 로그인 요청을 가로 챌 때, username, password 변수 2개를 가로채는데
	// password 부분 처리는 알아서함.
	// username이 DB에 있는지만 확인해주면 됨.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다." + username);
				});
		return new PrincipalDetail(principal);  //security session에 user 정보가 저장됨
	}
}
