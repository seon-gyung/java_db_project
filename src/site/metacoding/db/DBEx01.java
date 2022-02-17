package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx01 {

	public static void main(String[] args) {
		try {
			// 1. connection 연결 (세션 생성) port, IP주소, ID, password, protocol
			Connection conn = DriverManager.getConnection // 소켓 만든 것과 같음
					("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");

			// 2. 버퍼 달아서 통신 (SELECT * FROM emp)
			String sql = "SELECT empno, ename FROM emp"; // JAVA와 연동할 때는 끝에 세미콜론 필요 없음.
			PreparedStatement pstmt = conn.prepareStatement(sql); // 프로토콜이 정해진 버퍼. Buffered Writer
			ResultSet rs = pstmt.executeQuery(); // SELECT 할 때 사용. flush와 같은 개념임
			// pstmt.executeUpdate(); // INSERT, UPDATE, DELETE 할 때 사용. 커밋도 되고, 동기화도 적용됨
			// System.out.println(rs.next()); // 커서 한칸 내리기. boolean을 리턴함.
			
			while (rs.next()) {
				System.out.println("empno :" + rs.getInt("empno"));
				System.out.println("empno :" + rs.getString("ename"));
				System.out.println("================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
