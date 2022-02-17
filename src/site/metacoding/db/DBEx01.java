package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx01 {

	public static void main(String[] args) {
		try {
			// 1. connection ���� (���� ����) port, IP�ּ�, ID, password, protocol
			Connection conn = DriverManager.getConnection // ���� ���� �Ͱ� ����
					("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB����Ϸ�");

			// 2. ���� �޾Ƽ� ��� (SELECT * FROM emp)
			String sql = "SELECT empno, ename FROM emp"; // JAVA�� ������ ���� ���� �����ݷ� �ʿ� ����.
			PreparedStatement pstmt = conn.prepareStatement(sql); // ���������� ������ ����. Buffered Writer
			ResultSet rs = pstmt.executeQuery(); // SELECT �� �� ���. flush�� ���� ������
			// pstmt.executeUpdate(); // INSERT, UPDATE, DELETE �� �� ���. Ŀ�Ե� �ǰ�, ����ȭ�� �����
			// System.out.println(rs.next()); // Ŀ�� ��ĭ ������. boolean�� ������.
			
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
