package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	@Autowired
	private StudentBO studentBO;
	
	// CUD
	
	// C: Create
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "노병서";
		String phoneNumber = "010-9876-5432";
		String email = "nbs@naver.com";
		String dreamJob = "CEO";
		
		StudentEntity student = studentBO.addStudent(name, phoneNumber, email, dreamJob);
				
		return student;	//@ResponseBody + return 객체 => JSON
	}
	
	// U: Update
	@GetMapping("/2")
	public StudentEntity update() {
		// id가 5번의 dreamJob을 변경	=> "돈까스왕"
		StudentEntity student = studentBO.updateStudentDreamJobById(5, "돈까스왕");
		return student;
	}
	
	
	// D: Delete
	@GetMapping("/3")
	public String delete() {
		// 삭제될 id: 3
		studentBO.deleteStudentById(3);
		
		return "삭제 완료";
	}
}




