package project0923;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame extends JFrame {
	private static final long serialVersionUID = 1L; // Ŭ���� ���
	//������
	public MyFrame() {
		// ������ Ÿ��Ʋ ����
		setTitle("FlowLayoutTest");
		// ������ ���� ��ư ������ ���α׷� ���� �ϰԲ� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�������� ũ�� ����
		setSize(600,200);
		
		// ������ -> �г� -> ��ư 5��
		// �г� ����
		JPanel panel1;
		
		
		// ��ư ������ ���� ��ư ��ü �迭�� ����
		
		JButton buttons[] = new JButton[5];
		
		// ��ư ��ü ����
		for(int i=0;i<5;i++) {
			buttons[i] = new JButton();
		}
		
		buttons[0].setText("��ư01");
		buttons[1].setText("��ư02");
		buttons[2].setText("��ư03");
		buttons[3].setText("B4");
		buttons[4].setText("��~~~~~~~~~�� ��ư05");
	
		//�г��� ��ġ�����ڸ� �����ϱ� ���� ��ġ������ ��ü�� ����
		FlowLayout flowLayOutObject = new FlowLayout(FlowLayout.CENTER);
		
		// �г� ����
		panel1 = new JPanel();
		
		//�г� ��ġ ���� ����
		panel1.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//�г��� ��ġ ������ ��ü�� �������ش�.
		panel1.setLayout(flowLayOutObject);
		
		//�г��� ��ư���� �߰��Ѵ�.
		
		for(int i=0;i<5;i++) {
			panel1.add(buttons[i]);
		}
		
		//�����ӿ� �г��� �߰��Ѵ�.
		add(panel1);
		//�������� ���̰� �����Ѵ�.
		setVisible(true);
		
	}
}


public class WDB {

	public static void main(String[] args) {
		//���� ���� MyFrame ��ü�� �����Ѵ�.
		MyFrame myFrameObject = new MyFrame();
		
		
	}

}