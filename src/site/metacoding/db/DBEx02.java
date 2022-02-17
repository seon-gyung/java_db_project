package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// dept 테이블의 모든 내용을 출력하시오
// 쿼리문 SELECT deptno, dname, loc FROM dept
public class DBEx02 {

	public static void main(String[] args) {
		try {
			// 1. connection 연결!
			Connection conn = DriverManager.getConnection // 소켓 만든 것과 같음
					("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			// 2. 버퍼 달기!
			String sql = "SELECT deptno, dname, loc FROM dept"; // JAVA와 연동할 때는 끝에 세미콜론 필요 없음.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); // SELECT
			
			while (rs.next()) {
				System.out.println("deptno : " + rs.getInt("deptno") );
				System.out.println("dname : " + rs.getString("dname") );
				System.out.println("loc : " + rs.getString("loc") );
				System.out.println("================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
