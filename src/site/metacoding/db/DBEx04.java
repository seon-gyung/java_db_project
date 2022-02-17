package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// ﻿prepareStatement 변수 바인딩 하기
public class DBEx04 {
	
	public static void login(String username, String password) {
		try {
			Connection conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");
			
			// 1. 변수 앞 뒤 홑따옴표 제거
			String sql = "SELECT * FROM userTbl WHERE username = "+username+" AND password = "+password+" "; 
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql); 

			
			while (rs.next()) {
				System.out.println("로그인 되었습니다.");
				Session.isLogin= true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// 2. 메서드 호출시에 홑따옴표 넣음
		login(" 'ssar' ", " '123123' OR 1=1 ");
		
		System.out.println(Session.isLogin);
	}

}
