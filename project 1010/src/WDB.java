import java.sql.*;

public class WDB {

	public static void main(String[] args) {
		addBook("a", "b", "2002", 35000);
	}

	private static void addBook(String title, String pub, String year, int price) {
		Connection con = makeConnection();
		//Statement 객체를 생성
		Statement stmt = null;
		try {
			stmt = con.createStatement();			
		}
		catch (SQLException e) {
			System.out.println("예외 발생 : Statement객체를 만들다가 오류 생겼어요~");
		}
		//book 테이블의 book_id의 최대 값을 얻어와서
		// 1을 증가시킨 값을 새로운 book_id로 저장한다.
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
			System.out.println("반영된 레코드의 수 : "+i);
		} catch (SQLException e) {
			System.out.println("예외 발생 : insert 하다가 발생");
		}
	}
	
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

}
