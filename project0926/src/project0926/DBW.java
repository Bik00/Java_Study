package project0926;

import java.sql.*;

public class DBW {

	public static void main(String[] args) throws Exception{

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
		
		//데이터베이스로 보낼 쿼리문을 생성한다.
		Statement stmt = conn.createStatement();
		
		// 결과 레코드를 저장할 집합 변수를 만들어준다.
		ResultSet rs;
		
		// 질의 보내고 결과를 받는다.
		rs = stmt.executeQuery("select EMPNO, ENAME, JOB, MGR, SAL, COMM, DEPTNO, DEPTNAME, To_char(Hiredate, 'yy/mm/dd') mydate from emp");
		
//		// 첫번째 레코드로 커스를 이동시키는 명령 실행
//		rs.next();
//		// 첫번째 레코드만 출력해보자.
//		// 이름을 얻어온다.
//		String name = rs.getString("ENAME");
//		System.out.print(name+", ");
//		String job = rs.getString("JOB");
//		System.out.println(job);

		while(rs.next()) {
			int empno = rs.getInt("EMPNO");
			System.out.print(empno+", ");
			String name = rs.getString("ENAME");
			System.out.print(name+", ");
			String job = rs.getString("JOB");
			System.out.print(job+", ");
			int mgr = rs.getInt("MGR");
			System.out.print(mgr+", ");
			String mydate = rs.getString("mydate");
			System.out.print(mydate+", ");
			String sal = rs.getString("SAL");
			System.out.print(sal+", ");
			String comm = rs.getString("COMM");
			System.out.print(comm+", ");
			String deptno = rs.getString("DEPTNO");
			System.out.print(deptno+", ");
			String deptname = rs.getString("DEPTNAME");
			System.out.println(deptname);
		}
		

		stmt.close();
		
		if(conn != null) {
			conn.close(); //접속을 끊는다.
		}
		
	}

}
