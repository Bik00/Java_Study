package project1014;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
// 1.������ Ŭ���� ����
class MyListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// � ��ư���� �ҷ������� �ش� ��ü�� �����´�.
		JButton b = (JButton) e.getSource();
		b.setText("ȫ�浿");
	}
	
}

class MyFrame extends JFrame {
	//��� ����
	JButton button;
	//������
	public MyFrame() {
		// 2.1 ����� ���� ������ ��ü ����
		MyListener myListener = new MyListener();
		
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("��ư ������ ��");
		// 2.2 �ش� ������Ʈ�� ������ ��ü ���
		button.addActionListener(myListener);
		this.add(button);
		this.setVisible(true);
	}
}

public class WDB {
	public static void main(String[] args) {
		new MyFrame();
	}

}
