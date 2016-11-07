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
		setTitle("�׽�Ʈ");

		JPanel panel = new JPanel();
		txFieldTitle = new JTextField(10);
		txFieldTitle.setText("��ü����");
		txFieldPub = new JTextField(10);
		txFieldPub.setText("�������ǻ�");
		txFieldYear = new JTextField(10);
		txFieldYear.setText("2016");
		txFieldPrice = new JTextField(10);
		txFieldPrice.setText("20000");

		panel.add(new JLabel("����"));
		panel.add(txFieldTitle);
		panel.add(new JLabel("���ǻ�"));
		panel.add(txFieldPub);
		panel.add(new JLabel("�⵵"));
		panel.add(txFieldYear);
		panel.add(new JLabel("���� "));
		panel.add(txFieldPrice);

		JButton buttonRegister = new JButton("���");
		panel.add(buttonRegister);

		add(panel);
		setVisible(true);

		// 2.2 ������ �������� ��ü�� �����Ͽ� ��ư�� ���
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
			// 2. Ŀ�ؼ� ��ü ����
			String url = "jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
			String id = "s1201089";
			String pw = "p1201089";
			Connection conn = DriverManager.getConnection(url, id, pw);
			// ���ο� BOOK_ID�� �����ϱ� ���� ���� �ִ� BOOK_ID ���� B�κ��� �ִ´�.
			String string1 = "select max(BOOK_ID) from BOOKS";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(string1);
			rs.next();
			int value = rs.getInt(1);
			// ���ο� BOOK_ID
			value = value + 1;

			// 3. PreparedStatement ��ü ����
			String sql = "insert into BOOKS(BOOK_ID, TITLE,PUBLISHER, YEAR, PRICE)" + "values(?, ?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);

			// 4. ?���� �����ϱ� ���� ����
			psmt.setInt(1, value); // BOOK_ID�� ����
			psmt.setString(2, memberMyFrame.txFieldTitle.getText()); // å ���� ����
			psmt.setString(3, memberMyFrame.txFieldPub.getText()); // ���ǻ� ����
			psmt.setString(4, memberMyFrame.txFieldYear.getText()); // �⵵ ����
			String StrPrice = memberMyFrame.txFieldPrice.getText();
			int IntPrice = Integer.parseInt(StrPrice);
			psmt.setInt(5, IntPrice); // ���� ����
			psmt.executeUpdate();

			// 5. ���� ����

			psmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("���� �߻� : Ŭ������ �߰��� �� ���׿�");
			// e.printStackTrace();
		}
	}
}
