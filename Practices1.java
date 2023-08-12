package practices.oop;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

class Gui extends JFrame implements ActionListener{
	
	JLabel l1,Res,l;
	JTextField t1,t2;
	JButton btn1;
	JPanel p;
	Container contentpane;
	public Gui(String Title) {
		super(Title);
		setLayout(new GridLayout(3,3,20,20));
		
		l =new JLabel();
		l1 = new JLabel("Heelo calculate");
		t1 = new JTextField();
		t2 = new JTextField();
		btn1 = new JButton("Calculate");
//		btn1.addActionListener(this);
		btn1.addActionListener(this);
		
		p=new JPanel();
		
		Res = new JLabel();
		add(l);
		add(l1);
		add(t1);
		add(t2);
		
		add(btn1);
		
		p.add(Res);
		
		p.setBackground(Color.blue);
		contentpane =this.getContentPane();
		contentpane.add(p, BorderLayout.CENTER);
		contentpane.add(Res, BorderLayout.CENTER);
		
	}
	public void actionPerformed(ActionEvent e) {
		Double num1 = Double.parseDouble(t1.getText());
		Double num2 = Double.parseDouble(t2.getText());
		
		Double num3 = num1 + num2;
		Res.setText("Result: "+num3);
	}
	
}
public class Practices1 {

	public static void main(String[] args) {
		JFrame g = new Gui("gui");
		g.setVisible(true);
		g.setSize(400,400);
		g.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
