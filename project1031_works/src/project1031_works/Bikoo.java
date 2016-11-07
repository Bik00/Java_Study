package project1031_works;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;




class CountDown extends JFrame {
	private JLabel label;
	
	class MyThread implements Runnable {
		@Override
		public void run() {
			
			for(int i = 0; i< 10 ; i++) {
				try {		
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				label.setText((10-i)+"");
			}
		}
		
	}

	
	public CountDown() {
		setTitle("카운트다운");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("Start");
		label.setFont(new Font("Serif", Font.BOLD, 100));
		this.add(label);
		Thread a = new Thread(new MyThread());
		a.start();
		setVisible(true);
	}
}
	


public class Bikoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDown a = new CountDown();

		Thread thread = new Thread();

		thread.start();
	}

}
