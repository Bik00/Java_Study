package project0923;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame extends JFrame {
	private static final long serialVersionUID = 1L; // 클래스 상수
	//생성자
	public MyFrame() {
		// 프레임 타이틀 설정
		setTitle("FlowLayoutTest");
		// 윈도우 종료 버튼 누르면 프로그램 종료 하게끔 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//프레임의 크기 변경
		setSize(600,200);
		
		// 프레임 -> 패널 -> 버튼 5개
		// 패널 생성
		JPanel panel1;
		
		
		// 버튼 생성을 위해 버튼 객체 배열을 생성
		
		JButton buttons[] = new JButton[5];
		
		// 버튼 객체 생성
		for(int i=0;i<5;i++) {
			buttons[i] = new JButton();
		}
		
		buttons[0].setText("버튼01");
		buttons[1].setText("버튼02");
		buttons[2].setText("버튼03");
		buttons[3].setText("B4");
		buttons[4].setText("로~~~~~~~~~옹 버튼05");
	
		//패널의 배치관리자를 설정하기 위해 배치관리자 객체를 생성
		FlowLayout flowLayOutObject = new FlowLayout(FlowLayout.CENTER);
		
		// 패널 생성
		panel1 = new JPanel();
		
		//패널 배치 방향 설정
		panel1.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//패널의 배치 관리자 객체를 설정해준다.
		panel1.setLayout(flowLayOutObject);
		
		//패널의 버튼들을 추가한다.
		
		for(int i=0;i<5;i++) {
			panel1.add(buttons[i]);
		}
		
		//프레임에 패널을 추가한다.
		add(panel1);
		//프레임을 보이게 설정한다.
		setVisible(true);
		
	}
}


public class WDB {

	public static void main(String[] args) {
		//내가 만든 MyFrame 객체를 생성한다.
		MyFrame myFrameObject = new MyFrame();
		
		
	}

}