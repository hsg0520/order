package com.hsg.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hsg.order.config.auth.PrincipalDetailService;



@Configuration  //빈등록
@EnableWebSecurity // 시큐리티 필터가 등록이 된다. 
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리체크 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String[] PUBLIC = new String[]{
			"/error", "/login", "/api/login", "/logout", "/api/registrations"};
	  
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean //IoC가 됨
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	//시큐리티가 대신 로그인해주는데 Password를 가로채기하는데
	//해당 password가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
	//같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음 

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable() //csrf 비활성화, 테스트시 비활성화하는게 좋음
		.authorizeRequests()
		.antMatchers(PUBLIC) //auth로 들어오는건 누구나 들어올수있다
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login") // 인증이 안된 페이지에 접근할 경우 login페이지로 이동
		.loginProcessingUrl("/api/login")  // 스프링 시큐리티가 해당주소로 요청오는 로그인을 가로채서 대신 로그인해준다.
		.defaultSuccessUrl("/");
	}
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/static/**", "/js/**", "/css/**", "/images/**", "/favicon.ico");
	}


}

// XSS -> 자바스크립트 공격  naver에서 제공하는 lucy 필터를 사용하면 간단하게 막을수있음
// csrf -> 스프링이 요청시에 csrf토큰이 없으면 막아버림
