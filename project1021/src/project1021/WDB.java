package project1021;

import java.sql.*;

public class WDB {

	public static void main(String[] args) throws Exception {
		//1. 드라이버 로딩
		//2. 커넥션 객체 생성
		//--3. Statement 객체 생성
		//3. PreparedStatement 객체 생성
		// 4. 질의실행
		
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("예외 발생 : 클래스를 발견할 수 없네요");
		//	e.printStackTrace();
		}
		//2. 커넥션 객체 생성
		String url ="jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1201089";
		String pw = "p1201089";
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		//3. PreparedStatement 객체 생성
		String sql = "delete books where TITLE=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		
		// 4. ?값을 설정하기 위해 설정
		psmt.setString(1,"Head First SQL"); // BOOK_ID 번호를 설정
		psmt.executeUpdate();
		
		// 5. 연결 종료
		
		psmt.close();
		conn.close();
	}

}