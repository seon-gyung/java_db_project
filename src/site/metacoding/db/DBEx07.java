package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBEx07 {

	public static void main(String[] args) {
		try {
			// 1. connection ���� (���� ����) port, IP�ּ�, ID, password, protocol
			Connection conn = DriverManager.getConnection // ���� ���� �Ͱ� ����
					("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB����Ϸ�");

			// 2. ���� �޾Ƽ� ��� (SELECT * FROM emp)
			String sql = "DELETE FROM userTbl WHERE id = ?"; // JAVA�� ������ ���� ���� �����ݷ� �ʿ� ����.
			PreparedStatement pstmt = conn.prepareStatement(sql); // ���������� ������ ����. Buffered Writer
			pstmt.setInt(1, 7); // ����ǥ�� ����, ��
			// �������� -1 ����, �����ϸ� ����� ���(����, ����, ����)�� row���� ����, �ƹ� ��ȭ ������ 0 ����
			int result = pstmt.executeUpdate(); // delete, update, insert (���ο� commit ����)

			if (result > 0) {
				System.out.println("����"); // 1
			} else {
				System.out.println("����"); // 0
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
