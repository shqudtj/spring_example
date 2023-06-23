package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		// 1) List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("딸기");
		fruits.add("수박");
		fruits.add("배");
		fruits.add("바나나");
		fruits.add("멜론");
		model.addAttribute("fruits", fruits);
		
		// 2) List<Map>
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "노병서");
		user.put("age", 30);
		user.put("hobby", "유튜브");
		users.add(user);
		
		user = new HashMap<String, Object>();
		user.put("name", "김가나");
		user.put("age", 29);
		user.put("hobby", "끝말잇기");
		users.add(user);
		
		
		model.addAttribute("users", users); // 변수명자리에 맵인지 list인지 체크중요!!!
		
		
		
		return "lesson05/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		Date now = new Date();
		model.addAttribute("today", now);
		
		return "lesson05/ex03";
	}
	
	
	@GetMapping("/ex04")
	public String ex04() {
		return "lesson05/ex04";
	}
	
}




