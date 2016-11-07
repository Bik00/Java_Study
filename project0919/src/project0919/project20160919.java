package project0919;
import java.awt.*;

import javax.swing.*;
// JFrame 클래스를 상속받아 나만의 컨테이너 클래스를 생성하자
class MyJFrame extends JFrame {
	// 생성자
	public MyJFrame() {
		JFrame f = new JFrame("홍길동 MyJFrame"); //frame의 이름
		setSize(600,300); //창의 기본사이즈
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이걸 입력하면 클로즈 눌렀을 때 종료되도록 한다.
		setResizable(false);
		setLayout(new BorderLayout()); //배치관리자 설정
		
		JPanel panel01 = new JPanel();
		JPanel panel02 = new JPanel();
		
		JLabel label = new JLabel("안녕하세요");
		JLabel label1 = new JLabel("남쪽나라");
		JButton button = new JButton("버튼01");
		JButton button1 = new JButton("남쪽나라");
		
		panel01.add(label);
		panel01.add(button);
		this.add(panel01, BorderLayout.NORTH);
		
		panel02.add(label1);
		panel02.add(button1);
		this.add(panel02, BorderLayout.SOUTH);
		
		JPanel panel03 = new JPanel();
		JTextField textField01 = new JTextField();
		JTextField textField02 = new JTextField();
		textField01.setText("텍스트 필드01");
		textField02.setText("입력이 가능한 텍스트 필드");
		panel03.add(textField01);
		panel03.add(textField02);
		this.add(panel03, BorderLayout.CENTER);
		
//		JButton button = new JButton("확인");
//		// 생성된 버튼 컴포넌트를 컨테이너에 추가
//		this.add(button, BorderLayout.NORTH);
//		
//		JButton button1 = new JButton("홍길동");
//		this.add(button1, BorderLayout.EAST);
//		
//		JButton button2 = new JButton("고길동");
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
