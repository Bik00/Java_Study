package project1010_2;

import java.sql.*;
import java.util.Scanner;

public class project1010_2 {


	private static Connection makeConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("���� �߻� : Ŭ������ �߰��� �� ���׿�");
			return null;
		//	e.printStackTrace();
		}
		System.out.println("Ŭ���� �ε� ����");
		
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1201089";
		String pw = "p1201089";
		
		try {
			conn = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			System.out.println("���� �߻� : getConnection ����");
			return null;
		//	e.printStackTrace();
		}
		System.out.println("�����ͺ��̽� ���� ����");
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = makeConnection();
		//Ű����� �Է¹��� ��ȣ�� ���ڵ带 �����ϴ� ��� ����
		Scanner sc = new Scanner(System.in);
		System.out.print("������ Ÿ��Ʋ�� �Է� : ");
		String no = sc.nextLine();
		String query = "delete books where TITLE= ";
		try {
			Statement stmt = conn.createStatement();
			query = query+"\'";
			query = query +no;
			query = query +"\'";
			int x = stmt.executeUpdate(query);
			System.out.println("������ ���� ���� �� : "+x);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
