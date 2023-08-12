package practices.oop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JOptionPane;

class MyException extends Exception {
	public MyException(String name) {
		super(name);
	}
	public String toString() {
		return "Invalid input";
	}
}
class SimpleCalculator extends JFrame {
	JLabel label1, label2, txtlbl1, txtlbl2;
	JButton b1, b2, b3, b4;
	JTextField text1, text2;
	SimpleCalculator(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		label1 = new JLabel("SIMPLE CALCULATOR");
		label1.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		label1.setBounds(60, 10, 300, 30);
		add(label1);
		text1 = new JTextField(60);
		text2 = new JTextField(60);
		text1.setBounds(100, 60, 120, 30);
		text2.setBounds(100, 100, 120, 30);
		b1 = new JButton("ADD");
		b2 = new JButton("SUB");
		b3 = new JButton("MUL");
		b4 = new JButton("DIV");
		b1.setBounds(100, 140, 60, 30);
		b2.setBounds(165, 140, 60, 30);
		b3.setBounds(100, 180, 60, 30);
		b4.setBounds(165, 180, 60, 30);
		label2 = new JLabel("");
		label2.setBounds(120, 230, 200, 30);
		add(label2);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(text1);
		add(text2);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				float num1 = Float.parseFloat(text1.getText());
				float num2 = Float.parseFloat(text2.getText());
				label2.setText("ADDITION :" + (num1 + num2));
			}
		});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				float num1 = Float.parseFloat(text1.getText());
				float num2 = Float.parseFloat(text2.getText());
				label2.setText("SUBTATION :" + (num1 - num2));
			}
		});
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				float num1 = Float.parseFloat(text1.getText());
				float num2 = Float.parseFloat(text2.getText());
				label2.setText("MULTIPLICATION :" + (num1 * num2));
			}
		});
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				float num1 = Float.parseFloat(text1.getText());
				float num2 = Float.parseFloat(text2.getText());
				label2.setText("DIVISION :" + (num1 / num2));
			}
		});
	}
}
public class program5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new SimpleCalculator("Simple Calculator");
		frame.setBounds(400, 200, 400, 300);
		frame.setVisible(true);
	}
}