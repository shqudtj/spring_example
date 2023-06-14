package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// JSP 화면 뿌리기
@Controller		// RestController 아님 주의!!!, ResponseBody 사용안함!!!!
public class Lesson01Ex02Controller {

	// http://localhost/lesson01/ex02
	// @ResponseBody를 사용하면 "" 안의 것을 출력하게됨
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		// jsp의 경로를 리턴한다.
		// "/WEB-INF/jsp/ .jsp" => prefix 먼저 suffix (application.properties 파일 안에 있음)
//		return "/WEB-INF/jsp/lesson01/ex02.jsp";  // jsp 경로
		return "lesson01/ex02";  // jsp 경로 // ""시작에 / 없이 시작인거 까먹지 않기
	}
}





