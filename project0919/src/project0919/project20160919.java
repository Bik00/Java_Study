package project0919;
import java.awt.*;

import javax.swing.*;
// JFrame Ŭ������ ��ӹ޾� ������ �����̳� Ŭ������ ��������
class MyJFrame extends JFrame {
	// ������
	public MyJFrame() {
		JFrame f = new JFrame("ȫ�浿 MyJFrame"); //frame�� �̸�
		setSize(600,300); //â�� �⺻������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �̰� �Է��ϸ� Ŭ���� ������ �� ����ǵ��� �Ѵ�.
		setResizable(false);
		setLayout(new BorderLayout()); //��ġ������ ����
		
		JPanel panel01 = new JPanel();
		JPanel panel02 = new JPanel();
		
		JLabel label = new JLabel("�ȳ��ϼ���");
		JLabel label1 = new JLabel("���ʳ���");
		JButton button = new JButton("��ư01");
		JButton button1 = new JButton("���ʳ���");
		
		panel01.add(label);
		panel01.add(button);
		this.add(panel01, BorderLayout.NORTH);
		
		panel02.add(label1);
		panel02.add(button1);
		this.add(panel02, BorderLayout.SOUTH);
		
		JPanel panel03 = new JPanel();
		JTextField textField01 = new JTextField();
		JTextField textField02 = new JTextField();
		textField01.setText("�ؽ�Ʈ �ʵ�01");
		textField02.setText("�Է��� ������ �ؽ�Ʈ �ʵ�");
		panel03.add(textField01);
		panel03.add(textField02);
		this.add(panel03, BorderLayout.CENTER);
		
//		JButton button = new JButton("Ȯ��");
//		// ������ ��ư ������Ʈ�� �����̳ʿ� �߰�
//		this.add(button, BorderLayout.NORTH);
//		
//		JButton button1 = new JButton("ȫ�浿");
//		this.add(button1, BorderLayout.EAST);
//		
//		JButton button2 = new JButton("��浿");
//		this.add(button2, BorderLayout.SOUTH);
//		
		setVisible(true);
//		invalidate();

	}
}

public class project20160919 {

	public static void main(String[] args) {

		MyJFrame f = new MyJFrame();

	}

}
