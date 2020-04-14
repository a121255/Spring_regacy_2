package com.iu.spring_2.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnect;

public class MemberDAO {
	
	public MemberDAO() {
		System.out.println("ㅜㅜ");
	}
	
	
	
	
	
	
	public int memberUpdate(MemberVO memberVO) throws Exception {
		Connection con = DBConnect.getConnect();
		System.out.println("111");
		String sql = "update member set email=?, phone=?, age=?, name=? where id=?"; 
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberVO.getEmail());
		st.setString(2, memberVO.getPhone());
		st.setInt(3, memberVO.getAge());
		st.setString(4, memberVO.getName());
		st.setString(5, memberVO.getId());
		System.out.println("222");
		int result = st.executeUpdate();
		
		System.out.println("333");
		
		st.close();
		con.close();
				
		return result;
	}
	
	
	
	
	
	
	
	public int memberDelete(String id) throws Exception {
		Connection con = DBConnect.getConnect();
		
		String sql = "delete  from member where id=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		
		st.setString(1, id);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		
		Connection con = DBConnect.getConnect();
		
		String sql = "select * from member where id=? and pw=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberVO.getId());
		st.setString(2, memberVO.getPw());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			memberVO.setName(rs.getString("name"));
			memberVO.setEmail(rs.getString("email"));
			memberVO.setPhone(rs.getString("phone"));
			memberVO.setAge(rs.getInt("age"));
		}else {
			memberVO = null;
		}
		
		
		
		
		
		rs.close();
		st.close();
		con.close();
		
		
		
		
		return memberVO;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public int MemberJoin(MemberVO memberVO) throws Exception {
		Connection con = DBConnect.getConnect();
		
		
		
		String sql = "insert into member values (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberVO.getId());
		st.setString(2, memberVO.getPw());
		st.setString(3, memberVO.getName());
		st.setString(4, memberVO.getEmail());
		st.setString(5, memberVO.getPhone());
		st.setInt(6, memberVO.getAge());
		
		
		
		int result = st.executeUpdate();
		
		
		st.close();
		con.close();
		
		return result;
	}
	
}
