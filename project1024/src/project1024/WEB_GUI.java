package project1024;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class WEB_GUI {

 public static void main(String[] args) {
  MyFrame  f = new MyFrame();
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
  JButton buttonResult = new JButton("�������");
  panel.add(buttonRegister);
  panel.add(buttonResult);

  add(panel);
  setVisible(true);
  
  // 2.2 ������ �������� ��ü�� �����Ͽ� ��Ϲ�ư�� ���
	MyListener myListener = new MyListener(this);
	buttonRegister.addActionListener(myListener);
	
	
	  // 2.2 ������ �������� ��ü�� �����Ͽ� ��������ư�� ���
	MyListener2 myListener2 = new MyListener2(this);
	buttonResult.addActionListener(myListener2);


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
			//���ο� BOOK_ID
			value = value+1;
			
			
			// 3. PreparedStatement ��ü ����
			String sql = "insert into BOOKS(BOOK_ID, TITLE,PUBLISHER, YEAR, PRICE)" +
			"values(?, ?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);

			// 4. ?���� �����ϱ� ���� ����
			psmt.setInt(1, value); //BOOK_ID�� ����
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


class MyListener2 implements ActionListener {
	private MyFrame memberMyFrame;

	public MyListener2(MyFrame object1) {
		memberMyFrame = object1;
	}

	@Override
	public void actionPerformed(ActionEvent args0) {
		String[][] source = null;
		System.out.println("������� ��ư Ŭ��");
		JFrame jframe1 = new JFrame("�������");
		jframe1.setSize(600, 300);
		jframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JTable ������Ʈ�� ������
		//���� �����͸� ��ü���� �����.
		//�� ��ü�� ����� ���ؼ��� B�κ��� �����͸� �����;��Ѵ�.
		//1. ����̹� �ε�
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//2. Ŀ�ؼ� ��ü ����
		String url ="jdbc:oracle:thin:@net.yjc.ac.kr:1521:orcl";
		String id = "s1201089";
		String pw = "p1201089";
		Connection conn = DriverManager.getConnection(url, id, pw);
		// books ���̺��� ���� ������ �����´�.
		String string2 = "select count(*) from BOOKS";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(string2);
		rs.next();
		int rowNum = rs.getInt(1);
		
		//books ���̺��� ��� �����͸� �����´�.
		String string1 = "select * from BOOKS";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(string1);
		// �����͸� String[][] source �迭�� �ִ´�.
		
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
		
	//	jframe1.add(jTable);
		jframe1.add(new JScrollPane(jTable));
		model.setValueAt("�ٲﰪ",  0 , 0);
		
		jframe1.setVisible(true);
	}
}

class JTableModel extends AbstractTableModel {
	Object[][] data = { { "1", "�ڼ�ȯ", "010-6564-1234" }, {"1301284", "�ֿ�ȯ", "010-4444-6666"}, {"1301045", "�輺��", "010-1111-2222" } };
	String[] name = {"�й�", "�̸�", "��ȭ��ȣ"};
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