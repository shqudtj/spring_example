package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@Controller	// RestController는 ResponseBody가 포함되어있으므로
			// jsp view를 못 사용함
@RequestMapping("/lesson04/ex01")
public class Lesson04Ex01Controller {

	@Autowired
	private UserBO userBO;
	// private ReviewBO reviewBO; 이렇게가 아니라
	
	//@Autowired
	// private ReviewBO reviewBO; 이렇게 따로 Autowired를 먹여줘야함
	
	
	// _view  => jsp화면이 뿌려지는 곳이라는 강사님만의 방식
	@RequestMapping(path = "/add_user_view", method = RequestMethod.GET)
	public String addUserView() {
		//		/WEB-INF/jsp/				.jsp    => prefix suffix
		return "lesson04/addUser";	// return은 내가 return하는 것이므로 requestmapping과는 다름
	}
	
	// http://localhost/lesson04/ex01/add_user_view
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,	// jsp파일의 form태그의 name=""의 ""과 연결됨
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value = "email", required = false) String email ,
											// required = false => null 허용
			@RequestParam(value = "introduce", required = false) String introduce
			) {
		
		// db insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// 결과 페이지
		return "lesson04/afterAddUser";
	}
	
	// http://localhost/lesson04/ex01/get_latest_user_view
	@GetMapping("/get_latest_user_view")
	public String getLatestUserView(Model model) { // Model: view 화면에 데이터를 사용할 수 있도록 담는 객체
		// db select - 가장 최근에 추가된 사람 한명 가져오기
		User user = userBO.getLatestUser();
		model.addAttribute("result", user);
		model.addAttribute("title", "회원 정보");
		
		// 결과 페이지
		return "lesson04/getLatestUser";
	}
}




