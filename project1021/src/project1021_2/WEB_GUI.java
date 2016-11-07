package project1021_2;

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

public class WEB_GUI {

	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}
}

class MyFrame extends JFrame {
	public JTextField txFieldTitle;
	public JTextField txFieldPub;
	public JTextField txFieldYear;
	public JTextField txFieldPrice;

	public MyFrame() {

		setSize(190, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("테스트");

		JPanel panel = new JPanel();
		txFieldTitle = new JTextField(10);
		txFieldTitle.setText("객체지향");
		txFieldPub = new JTextField(10);
		txFieldPub.setText("영진출판사");
		txFieldYear = new JTextField(10);
		txFieldYear.setText("2016");
		txFieldPrice = new JTextField(10);
		txFieldPrice.setText("20000");

		panel.add(new JLabel("제목"));
		panel.add(txFieldTitle);
		panel.add(new JLabel("출판사"));
		panel.add(txFieldPub);
		panel.add(new JLabel("년도"));
		panel.add(txFieldYear);
		panel.add(new JLabel("가격 "));
		panel.add(txFieldPrice);

		JButton buttonRegister = new JButton("등록");
		panel.add(buttonRegister);

		add(panel);
		setVisible(true);

		// 2.2 구현된 리스너의 객체를 생성하여 버튼에 등록
		MyListener myListener = new MyListener(this);
		buttonRegister.addActionListener(myListener);

	}
}

class MyListener implements ActionListener {
	private MyFrame memberMyFrame;

	public MyListener(MyFrame object1) {
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
			psmt.setString(2, memberMyFrame.txFieldTitle.getText()); // 책 제목 설정
			psmt.setString(3, memberMyFrame.txFieldPub.getText()); // 출판사 설정
			psmt.setString(4, memberMyFrame.txFieldYear.getText()); // 년도 설정
			String StrPrice = memberMyFrame.txFieldPrice.getText();
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
