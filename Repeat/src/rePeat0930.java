
import java.sql.*;

public class rePeat0930 {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// �����ͺ��̽� ����
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1201089";
		String pw = "p1201089";
		Connection conn = DriverManager.getConnection(url, id, pw);
		if(conn != null) {
		System.out.println("�����ͺ��̽��� ���� ����");
		}
		
		//�����ͺ��̽��� ���� �������� �����Ѵ�.
		Statement stmt = conn.createStatement();
		
		// ��� ���ڵ带 ������ ���� ������ ������ش�.
		ResultSet rs;
		
		// ���� ������ ����� �޴´�.
		rs = stmt.executeQuery("select * from BOOKS");
		

		while(rs.next()) {
			String title = rs.getString("TITLE");
			System.out.println(title);
		}
		

		stmt.close();
		
		if(conn != null) {
			conn.close(); //������ ���´�.
		}

	}

}