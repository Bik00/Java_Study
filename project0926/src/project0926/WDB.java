package project0926;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame extends JFrame{
	//생성자
	public MyFrame() {
		setTitle("홍길동");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//배치 관리자 생성 및 설정
		GridLayout g = new GridLayout(2,4); // 2행 4열
		setLayout(g);
		
		//버튼 객체를 만들어서 프레임에 추가
		add(new JButton("버튼 01"));
		add(new JButton("버튼 02"));
		add(new JButton("버튼 03"));
		add(new JButton("버튼 04"));
		add(new JButton("버튼 05"));
		add(new JButton("버튼 06"));
		add(new JButton("버튼 07"));
		add(new JButton("버튼 08"));
		
		pack(); // 컴포넌트를 적절하게 맞춰보자.
		setVisible(true);
	}
}


public class WDB {

	public static void main(String[] args) {
		MyFrame m = new MyFrame();
	}

}
