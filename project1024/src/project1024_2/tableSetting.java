package project1024_2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

class frameSet extends JFrame {
	private JButton playButton;
	private JButton resultButton;
	private JLabel label = null;
	public JTextField a;
	public JTextField b;
	public JTextField c;
	public JTextField d;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();

	public frameSet() {
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("입력창");

		setLayout(new GridLayout(5, 1));

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		a = new JTextField(10);
		a.setText("객체지향");
		b = new JTextField(10);
		b.setText("영진출판사");
		c = new JTextField(10);
		c.setText("2016");
		d = new JTextField(10);
		d.setText("20000");

		playButton = new JButton("등록");
		resultButton = new JButton("결과보기");

		panel1.add(new JLabel("제목 :"));
		panel1.add(a);
		panel2.add(new JLabel("출판사 :"));
		panel2.add(b);
		panel3.add(new JLabel("년도 :"));
		panel3.add(c);
		panel4.add(new JLabel("가격 :"));
		panel4.add(d);
		panel5.add(playButton);
		panel5.add(resultButton);

		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		this.setVisible(true);

		  // 2.2 구현된 리스너의 객체를 생성하여 등록버튼에 등록
		MyListener myListener = new MyListener(this);
		playButton.addActionListener(myListener);
		
		
		  // 2.2 구현된 리스너의 객체를 생성하여 결과보기버튼에 등록
		MyListener2 myListener2 = new MyListener2(this);
		resultButton.addActionListener(myListener2);

	}
}

class MyListener implements ActionListener {
	private frameSet memberMyFrame;

	public MyListener(frameSet object1) {
		memberMyFrame = object1;
	}

	@Override
	public void actionPerformed(ActionEvent args0) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 커넥션 객체 생성
			String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
			String id = "s1201089";
			String pw = "p1201089";
			Connection conn = DriverManager.getConnection(url, id, pw);
			// 새로운 BOOK_ID를 생성하기 위해 현재 최대 BOOK_ID 값을 B로부터 넣는다.
			String string1 = "select max(BOOK_ID) from BOOKS";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(string1);
			rs.next();
			int value = rs.getInt(1);
			//새로운 BOOK_ID
			value = value+1;
			
			
			// 3. PreparedStatement 객체 생성
			String sql = "insert into BOOKS(BOOK_ID, TITLE,PUBLISHER, YEAR, PRICE)" +
			"values(?, ?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);

			// 4. ?값을 설정하기 위해 설정
			psmt.setInt(1, value); //BOOK_ID를 설정
			psmt.setString(2, memberMyFrame.a.getText()); // 책 제목 설정
			psmt.setString(3, memberMyFrame.b.getText()); // 출판사 설정
			psmt.setString(4, memberMyFrame.c.getText()); // 년도 설정
			String StrPrice = memberMyFrame.d.getText();
			int IntPrice = Integer.parseInt(StrPrice);
			psmt.setInt(5, IntPrice); // 가격 설정
			psmt.executeUpdate();

			// 5. 연결 종료

			psmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("예외 발생 : 클래스를 발견할 수 없네요");
			// e.printStackTrace();
		}
	}
}

class MyListener2 implements ActionListener {
	private frameSet memberMyFrame;

	public MyListener2(frameSet object1) {
		memberMyFrame = object1;
	}

	@Override
	public void actionPerformed(ActionEvent args0) {
		String[][] source = null;
		System.out.println("결과보기 버튼 클릭");
		JFrame jframe1 = new JFrame("결과보기");
		jframe1.setSize(600, 300);
		jframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JTable 컴포넌트를 만들자
		//먼저 데이터모델 객체부터 만든다.
		//모델 객체를 만들기 위해서는 B로부터 데이터를 가져와야한다.
		//1. 드라이버 로딩
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//2. 커넥션 객체 생성
		String url ="jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1201089";
		String pw = "p1201089";
		Connection conn = DriverManager.getConnection(url, id, pw);
		// books 테이블의 행의 개수를 가져온다.
		String string2 = "select count(*) from BOOKS";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(string2);
		rs.next();
		int rowNum = rs.getInt(1);
		
		//books 테이블의 모든 데이터를 가져온다.
		String string1 = "select * from BOOKS";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(string1);
		// 데이터를 String[][] source 배열에 넣는다.
		
		source = new String[rowNum][5];
		int i=0;
		while(rs.next()) {
			source[i][0] = rs.getInt("Book_id")+"";
			source[i][1] = rs.getString("title")+"";
			source[i][2] = rs.getString("publisher")+"";
			source[i][3] = rs.getString("year")+"";
			source[i][0] = rs.getInt("price")+"";
			i++;
		}
		
		stmt.close();
		conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JTableModel2 model = new JTableModel2();
		model.setData(source);
		JTable jTable = new JTable(model);
		
		jframe1.add(jTable);
		model.setValueAt("바뀐값",  0 , 0);
		
		jframe1.setVisible(true);
	}
}

class JTableModel extends AbstractTableModel {
	Object[][] data = { { "1", "박세환", "010-6564-1234" }, {"1301284", "최용환", "010-4444-6666"}, {"1301045", "김성흠", "010-1111-2222" } };
	String[] name = {"학번", "이름", "전화번호"};
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return name.length;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
}

class JTableModel2 extends AbstractTableModel {
	Object[][] data = {};
	String[] name = { "Book_id", "title", "publisher", "year", "price"};
	
	public void setData(String[][] input) {
		this.data = input;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return name.length;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
}


public class tableSetting {

	public static void main(String[] args) {
		frameSet t = new frameSet();
	}

}