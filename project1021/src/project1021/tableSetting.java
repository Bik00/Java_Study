package project1021;

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
import javax.swing.JTextField;

class frameSet extends JFrame {
	private JButton playButton;
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

		panel1.add(new JLabel("제목 :"));
		panel1.add(a);
		panel2.add(new JLabel("출판사 :"));
		panel2.add(b);
		panel3.add(new JLabel("년도 :"));
		panel3.add(c);
		panel4.add(new JLabel("가격 :"));
		panel4.add(d);
		panel5.add(playButton);

		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		this.setVisible(true);

		MyListener myListener = new MyListener(this);
		playButton.addActionListener(myListener);

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
			// 새로운 BOOK_ID
			value = value + 1;

			// 3. PreparedStatement 객체 생성
			String sql = "insert into BOOKS(BOOK_ID, TITLE,PUBLISHER, YEAR, PRICE)" + "values(?, ?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);

			// 4. ?값을 설정하기 위해 설정
			psmt.setInt(1, value); // BOOK_ID를 설정
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

public class tableSetting {

	public static void main(String[] args) {
		frameSet t = new frameSet();
	}

}