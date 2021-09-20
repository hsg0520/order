package com.hsg.order.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 mysql에 테이블이 생성이 된다
public class User {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //시퀀스 auto_increment
	
	@Column(nullable = false, length = 20)
	private String username;
	
	@Column(nullable = false, length = 100) //해쉬(비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@ColumnDefault("'user'") // ' 문자라는걸 알려줘야함
	private String role; //admin, user, manager 등.. enum을 활용하는게 좋음
	
	@CreationTimestamp // insert가 될 때 시간이 자동으로 입력
	private Timestamp createDate;
}
