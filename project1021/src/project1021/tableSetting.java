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
		this.setTitle("�Է�â");

		setLayout(new GridLayout(5, 1));

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		a = new JTextField(10);
		a.setText("��ü����");
		b = new JTextField(10);
		b.setText("�������ǻ�");
		c = new JTextField(10);
		c.setText("2016");
		d = new JTextField(10);
		d.setText("20000");

		playButton = new JButton("���");

		panel1.add(new JLabel("���� :"));
		panel1.add(a);
		panel2.add(new JLabel("���ǻ� :"));
		panel2.add(b);
		panel3.add(new JLabel("�⵵ :"));
		panel3.add(c);
		panel4.add(new JLabel("���� :"));
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
			psmt.setString(2, memberMyFrame.a.getText()); // å ���� ����
			psmt.setString(3, memberMyFrame.b.getText()); // ���ǻ� ����
			psmt.setString(4, memberMyFrame.c.getText()); // �⵵ ����
			String StrPrice = memberMyFrame.d.getText();
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

public class tableSetting {

	public static void main(String[] args) {
		frameSet t = new frameSet();
	}

}