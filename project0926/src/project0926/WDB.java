package project0926;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame extends JFrame{
	//������
	public MyFrame() {
		setTitle("ȫ�浿");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ġ ������ ���� �� ����
		GridLayout g = new GridLayout(2,4); // 2�� 4��
		setLayout(g);
		
		//��ư ��ü�� ���� �����ӿ� �߰�
		add(new JButton("��ư 01"));
		add(new JButton("��ư 02"));
		add(new JButton("��ư 03"));
		add(new JButton("��ư 04"));
		add(new JButton("��ư 05"));
		add(new JButton("��ư 06"));
		add(new JButton("��ư 07"));
		add(new JButton("��ư 08"));
		
		pack(); // ������Ʈ�� �����ϰ� ���纸��.
		setVisible(true);
	}
}


public class WDB {

	public static void main(String[] args) {
		MyFrame m = new MyFrame();
	}

}
