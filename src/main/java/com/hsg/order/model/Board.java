package com.hsg.order.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

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
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터 
	private String content;
	
	@ColumnDefault("0")
	private int count; //조회수  
	
	@ManyToOne //board 가 many, user = one
	@JoinColumn(name="userId")
	private User user; // DB는 오브젝트를 저장 할 수 없다. FK, 자바는 오브젝트를 저장 할수 있다
	
	@CreationTimestamp
	private Timestamp createDate;
}
