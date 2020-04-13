package com.iu.spring_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sub/**")
public class SubController {
	
	@RequestMapping(value = "sub1")
	public void sub1() {
		//리턴할 경로명이 같으면 void러러ㅗ 해도 댐
		
	}
	
	
	@RequestMapping(value = "sub2")
	public String sub2() {
		return "sub/sub2";
		
	}

}
