package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBEx07 {

	public static void main(String[] args) {
		try {
			// 1. connection 연결 (세션 생성) port, IP주소, ID, password, protocol
			Connection conn = DriverManager.getConnection // 소켓 만든 것과 같음
					("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");

			// 2. 버퍼 달아서 통신 (SELECT * FROM emp)
			String sql = "DELETE FROM userTbl WHERE id = ?"; // JAVA와 연동할 때는 끝에 세미콜론 필요 없음.
			PreparedStatement pstmt = conn.prepareStatement(sql); // 프로토콜이 정해진 버퍼. Buffered Writer
			pstmt.setInt(1, 7); // 물음표의 순서, 값
			// 에러나면 -1 리턴, 성공하면 수행된 결과(생성, 삭제, 수정)의 row개수 리턴, 아무 변화 없으면 0 리턴
			int result = pstmt.executeUpdate(); // delete, update, insert (내부에 commit 존재)

			if (result > 0) {
				System.out.println("성공"); // 1
			} else {
				System.out.println("실패"); // 0
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
