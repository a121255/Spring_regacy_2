package com.iu.spring_2.member;

public class MemberService {
	private MemberDAO memberDAO;
	
	
	
	public MemberService(MemberDAO memberDAO) {
		System.out.println("되나?");
		this.memberDAO = memberDAO;
		
	}

	
	public int MemberUpdate(MemberVO memberVO) throws Exception {
		System.out.println("service");
		return memberDAO.memberUpdate(memberVO);
	}
	
	
	
	public int MemberDelete(String id) throws Exception {
		System.out.println("DeleteService");
		return memberDAO.memberDelete(id);
	}
	
	public MemberVO MemberLogin(MemberVO memberVO) throws Exception {
		return memberDAO.memberLogin(memberVO);
	}
	
	
	public int MemberJoin(MemberVO memberVO) throws Exception {
		return memberDAO.MemberJoin(memberVO);
	}
}
