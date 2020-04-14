package com.iu.spring_2.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  //DispatcherServlet에서 부르겠다는 뜻?음...인식하기 위해 써줌 //controller라는 걸 알려주 ㅁ
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	

	
	

	@RequestMapping(value="memberDelete")
	public String memberDelete(HttpSession session, MemberVO memberVO, Model model) throws Exception {	
		System.out.println("memberDelete Page");
		memberVO = (MemberVO)session.getAttribute("member");
		int num = memberService.MemberDelete(memberVO.getId());
		session.invalidate();
		  
		
		
		
		
		
		
		return "redirect:../";
	}
	
	
	
	
	/*
	 * @RequestMapping(value="memberJoin") public void memberJoin(int num) {
	 * //Integer.parseInt 하기 귀찮음 -> 매개변수에 int num 쓰기 %num=헤서 써보기
	 * System.out.println("num"); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @RequestMapping(value="memberJoin") public String
	 * memberJoin(HttpServletRequest request) { String id =
	 * request.getParameter("id"); System.out.println(id); return
	 * "member/memberJoin"; }
	 */
	
	@RequestMapping(value= "memberJoin")
	public void memberJoin(Model model) {	//request와 같은 생명주기, response 나가면 사라짐
		
		String id = "test";
		model.addAttribute(id);	//request처럼 jsp까지 전달
		
		
		//retern model 해줘도 되고 안 해줘도 됨
	}
	
	
	
	
	@RequestMapping(value= "memberJoin", method = RequestMethod.POST)
	public void memberJoin2(MemberVO memberVO) { //dispatcherServlet이 new memeberVO 만들어서 set을 대신 해줘서 넘겨 주는 것
		//매개변수 선언해서 받아오기...? 먼소리지?
		
		
		
		System.out.println(memberVO.getId());
		System.out.println(memberVO.getName());
		
	
		
		System.out.println("Member Join Post");
	}
	
	
	
	
	@RequestMapping(value="memberLogin")
	public String memberLogin() {
		return  "member/memberLogin";
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String memberLogin2(MemberVO memberVO, HttpSession session, Model model) throws Exception { //dispatcherServlet이 대신 해서 보내주는 것
		System.out.println("Login");
		//id, pw 넘어옴
	
		
		/*
		 * memberVO.setId((String)session.getAttribute("id"));
		 * memberVO.setPw((String)session.getAttribute("pw"));
		 */
		session.setAttribute("member", memberVO);
		
		memberVO = memberService.MemberLogin(memberVO);
		
		String path = null;
		if(memberVO != null) {
			
			
			path = "redirect:../";
		}else {
	
			model.addAttribute("result", "로그인 실패");
			model.addAttribute("path", "member/memberLogin");
			path = "common/result";
		}
			
		//로그인 성공이면 index 이동
		//로그인 실패이면 로그인 실패를 alert창에 띄우고 로그인 form으로 이동
		
		return path;
	}
	
	@RequestMapping(value="memberLogout")
	public String memberLogout(HttpSession session) {
		session.invalidate();
		
		
		return "../";
	}
	
	
	
	
	
	@RequestMapping(value="memberMypage")
	public String memberMypage(HttpSession session) {
		session.getAttribute("member");
		return "member/memberMypage";
	}
	
	
	
	@RequestMapping(value="memberUpdate")
	public String memberUpdate() {
		System.out.println("update page");
		return "member/memberUpdate";
	}

	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)
	public String memberUpdate2(MemberVO memberVO, HttpSession session, Model model) throws Exception {
		int num = memberService.MemberUpdate(memberVO);
		
		String path="";
		num = 0;
		if(num>0) {
			session.setAttribute("member", memberVO);
			path="member/memberMypage";
		}else {

			model.addAttribute("result","업데이트실패");
			model.addAttribute("path", "memberUpdate");
			
			path="common/result";
		}
		
		return path;
	}
}






