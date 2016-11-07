import java.sql.*;

public class WDB {

	public static void main(String[] args) {
		addBook("a", "b", "2002", 35000);
	}

	private static void addBook(String title, String pub, String year, int price) {
		Connection con = makeConnection();
		//Statement ��ü�� ����
		Statement stmt = null;
		try {
			stmt = con.createStatement();			
		}
		catch (SQLException e) {
			System.out.println("���� �߻� : Statement��ü�� ����ٰ� ���� ������~");
		}
		//book ���̺��� book_id�� �ִ� ���� ���ͼ�
		// 1�� ������Ų ���� ���ο� book_id�� �����Ѵ�.
		int new_id=0;
		
		try {
			ResultSet rs = stmt.executeQuery("select max(book_id) as maxvalue from books");
			rs.next();
			new_id = rs.getInt("maxvalue");
			new_id = new_id+1;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String s = "insert into books(book_id,TITLE,publisher,year,price) "+"values("+new_id+", 'a1', 'b', '2016', 35000)";
		try {
			int i = stmt.executeUpdate(s);
			System.out.println("�ݿ��� ���ڵ��� �� : "+i);
		} catch (SQLException e) {
			System.out.println("���� �߻� : insert �ϴٰ� �߻�");
		}
	}
	
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

}
