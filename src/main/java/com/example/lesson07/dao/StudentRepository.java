package com.example.lesson07.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	// 순수한 JPA => 어노테이션이 많아서 안 쓰는듯?
	
	
	// Spring Data JPA
	// save()
	
	// findById()
	
}
