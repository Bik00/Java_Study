package project1010_2;

import java.sql.*;
import java.util.Scanner;

public class project1010_2 {


	private static Connection makeConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("예외 발생 : 클래스를 발견할 수 없네요");
			return null;
		//	e.printStackTrace();
		}
		System.out.println("클래스 로딩 성공");
		
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1201089";
		String pw = "p1201089";
		
		try {
			conn = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			System.out.println("예외 발생 : getConnection 에러");
			return null;
		//	e.printStackTrace();
		}
		System.out.println("데이터베이스 연결 성공");
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = makeConnection();
		//키보드로 입력받은 번호의 레코드를 삭제하는 기능 구현
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 타이틀을 입력 : ");
		String no = sc.nextLine();
		String query = "delete books where TITLE= ";
		try {
			Statement stmt = conn.createStatement();
			query = query+"\'";
			query = query +no;
			query = query +"\'";
			int x = stmt.executeUpdate(query);
			System.out.println("영향을 받은 행의 수 : "+x);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
