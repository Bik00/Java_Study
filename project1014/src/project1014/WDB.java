package project1014;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
// 1.리스너 클래스 생성
class MyListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// 어떤 버튼에서 불러졌는지 해당 객체를 가져온다.
		JButton b = (JButton) e.getSource();
		b.setText("홍길동");
	}
	
}

class MyFrame extends JFrame {
	//멤버 변수
	JButton button;
	//생성자
	public MyFrame() {
		// 2.1 등록을 위한 리스너 객체 생성
		MyListener myListener = new MyListener();
		
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("버튼 누르기 전");
		// 2.2 해당 컴포넌트에 리스너 객체 등록
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
