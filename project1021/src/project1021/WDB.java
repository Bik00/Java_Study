package project1021;

import java.sql.*;

public class WDB {

	public static void main(String[] args) throws Exception {
		//1. ����̹� �ε�
		//2. Ŀ�ؼ� ��ü ����
		//--3. Statement ��ü ����
		//3. PreparedStatement ��ü ����
		// 4. ���ǽ���
		
		//1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("���� �߻� : Ŭ������ �߰��� �� ���׿�");
		//	e.printStackTrace();
		}
		//2. Ŀ�ؼ� ��ü ����
		String url ="jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1201089";
		String pw = "p1201089";
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		//3. PreparedStatement ��ü ����
		String sql = "delete books where TITLE=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		
		// 4. ?���� �����ϱ� ���� ����
		psmt.setString(1,"Head First SQL"); // BOOK_ID ��ȣ�� ����
		psmt.executeUpdate();
		
		// 5. ���� ����
		
		psmt.close();
		conn.close();
	}

}