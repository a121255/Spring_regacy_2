package com.iu.spring_2.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //DispatcherServlet에서 부르겠다는 뜻?음...인식하기 위해 써줌
@RequestMapping(value="/member/**")
public class MemberController {

	@RequestMapping(value="memberDelete")
	public String memberDelete() {
		System.out.println("memberDelete Page");
		return "member/memberDelete";
	}
	@RequestMapping(value="memberJoin")
	public String memberJoin() {
		return "member/memberJoin";
	}
	@RequestMapping(value="memberLogin")
	public String memberLogin() {
		System.out.println("Login");
		return "redirect:../";
	}
	@RequestMapping(value="memberMypage")
	public String memberMypage() {
		return "member/memberMypage";
	}
	@RequestMapping(value="memberUpdate")
	public String memberUpdate() {
		System.out.println("Update");
		return "member/memberUpdate";
	}
}
