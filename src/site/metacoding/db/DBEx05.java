package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// dept 테이블의 모든 내용을 출력하시오
// 쿼리문 SELECT deptno, dname, loc FROM dept
public class DBEx05 {

	public static void main(String[] args) {
		try {
			// 1. connection 연결!
			Connection conn = DriverManager.getConnection // 소켓 만든 것과 같음
					("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			// 2. 버퍼 달기!
			String sql = "SELECT deptno, dname, loc FROM dept"; // JAVA와 연동할 때는 끝에 세미콜론 필요 없음.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); // SELECT
			
			List<Dept> depts = new ArrayList<>();
			while (rs.next()) {
				Dept dept = new Dept(
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc")
				);
				depts.add(dept);
			}
			
			for(Dept dept : depts) {
				System.out.println("deptno : " + dept.getDeptno());
				System.out.println("dname : " + dept.getDname());
				System.out.println("loc : " + dept.getLoc());
				System.out.println("====================");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
