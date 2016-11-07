package project0926;

import java.sql.*;

public class DBW {

	public static void main(String[] args) throws Exception{

		Class.forName("oracle.jdbc.driver.OracleDriver");
		// �����ͺ��̽� ����
		String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "scott";
		String pw = "tiger";
		Connection conn =
				DriverManager.getConnection(url, id, pw);
		if(conn != null) {
		System.out.println("�����ͺ��̽��� ���� ����");
		}
		
		//�����ͺ��̽��� ���� �������� �����Ѵ�.
		Statement stmt = conn.createStatement();
		
		// ��� ���ڵ带 ������ ���� ������ ������ش�.
		ResultSet rs;
		
		// ���� ������ ����� �޴´�.
		rs = stmt.executeQuery("select EMPNO, ENAME, JOB, MGR, SAL, COMM, DEPTNO, DEPTNAME, To_char(Hiredate, 'yy/mm/dd') mydate from emp");
		
//		// ù��° ���ڵ�� Ŀ���� �̵���Ű�� ��� ����
//		rs.next();
//		// ù��° ���ڵ常 ����غ���.
//		// �̸��� ���´�.
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
			conn.close(); //������ ���´�.
		}
		
	}

}
