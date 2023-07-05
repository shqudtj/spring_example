package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "new_student")	// 이 클래스는 Entity라고 알리는 어노테이션
@Table(name = "new_student")	// 테이블명에 _없으면 생략해도됨 즉 _가 있으면 꼭 추가
@Getter		// getter
@Builder(toBuilder = true)	// setter 대용 tobuilder = true => 데이터내용지정해서 변경가능
@NoArgsConstructor	// 파라미터 없는 기본 생성자
@AllArgsConstructor	// 모든 필드를 인자값으로 받는 생성자
@ToString	// toString override 값 예쁘게 출력
public class StudentEntity {
	@Id	// 이 필드가 PK다
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// auti increment
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")	// CamelCase에는 붙여야함
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp	// createdAt이 null이면 현재 시간으로 자동입력
	@Column(name = "createdAt", updatable = false)	// updatable=false는 update시 시간 갱신 안함
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
	
}




