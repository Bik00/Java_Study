package project0926;

import java.sql.*;

public class deptSelect {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 데이터베이스 연결
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "scott";
		String pw = "tiger";
		Connection conn =
				DriverManager.getConnection(url, id, pw);
		if(conn != null) {
		System.out.println("데이터베이스와 연결 성공");
		}
		
		Statement stmt = conn.createStatement();
		ResultSet rs;
		rs = stmt.executeQuery("select DEPTNO, DNAME, LOC from dept");

		
		while(rs.next()) {

			String deptno = rs.getString("DEPTNO");
			System.out.print(deptno+", ");
			String dname = rs.getString("DNAME");
			System.out.print(dname+", ");
			String loc = rs.getString("LOC");
			System.out.println(loc);
		}
		

		stmt.close();
		
		if(conn != null) {
			conn.close(); //접속을 끊는다.
		}

	}

}
