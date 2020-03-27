import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame0 {
	private JFrame f;
	private JLabel lbl1,lbl2;
	private JTextField tf3,tf4,tf5,tf6,tf7;
	private JButton btn8;
	
	public Frame0() {
		
		initializeComponents();
		addComponents();
		addListeners();
		
		f.pack();
		f.setSize(400,400);
		f.setVisible(true);
		
	}
	
	public void initializeComponents() {
		
		f = new JFrame("Intro to Swing Cricket !!");
		
		lbl1 = new JLabel("Welcome to SWING CRICKET !!");
		lbl2 = new JLabel("The Flow of Play-");
		
		tf3 = new JTextField(" i.	Choose your Team");
		tf4 = new JTextField(" ii.	Choose opposition Team");
		tf5 = new JTextField(" iii.	Select the Overs to play and get the Target");
		tf6 = new JTextField(" iv.	Start the Chasing");
		tf7 = new JTextField(" v.	Have a look at the Summary and ScoreCard");
		
		btn8 = new JButton("Start the Game!!");
		
	}
	
	public void addComponents() {
		
		tf3.setEditable(false);tf3.setBackground(Color.gray);
		tf4.setEditable(false);tf4.setBackground(Color.gray);
		tf5.setEditable(false);tf5.setBackground(Color.gray);
		tf6.setEditable(false);tf6.setBackground(Color.gray);
		tf7.setEditable(false);tf7.setBackground(Color.gray);
		
		f.add(lbl1);
		f.add(lbl2);
		f.add(tf3);
		f.add(tf4);
		f.add(tf5);
		f.add(tf6);
		f.add(tf7);
		f.add(btn8);
		
		f.setLayout(new GridLayout(8,1,5,0));
		
	}
	
	public void addListeners() {
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Frame1();
				f.setVisible(false);
			}
		});
	}
	
	public static void main(String [] args) {
		new Frame0();
	}
}
