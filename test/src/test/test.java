package test;

import javax.swing.*;
import java.awt.Color;

public class test extends JFrame{
	private final JButton btnNewButton = new JButton("New button");
	public test() {
		setsize(500,500);
		getContentPane().setLayout(null);
		btnNewButton.setBounds(142, 90, 123, 31);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(151, 194, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(337, 239, 97, 23);
		getContentPane().add(btnNewButton_2);
		
		setVisible(true);
		
	}
	public static void main(String[] args){
		new test();
	}
}
