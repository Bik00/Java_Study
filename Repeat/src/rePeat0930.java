
import java.sql.*;

public class rePeat0930 {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 데이터베이스 연결
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1201089";
		String pw = "p1201089";
		Connection conn = DriverManager.getConnection(url, id, pw);
		if(conn != null) {
		System.out.println("데이터베이스와 연결 성공");
		}
		
		//데이터베이스로 보낼 쿼리문을 생성한다.
		Statement stmt = conn.createStatement();
		
		// 결과 레코드를 저장할 집합 변수를 만들어준다.
		ResultSet rs;
		
		// 질의 보내고 결과를 받는다.
		rs = stmt.executeQuery("select * from BOOKS");
		

		while(rs.next()) {
			String title = rs.getString("TITLE");
			System.out.println(title);
		}
		

		stmt.close();
		
		if(conn != null) {
			conn.close(); //접속을 끊는다.
		}

	}

}