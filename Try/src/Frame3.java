import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Frame3 {
	private JFrame f;
	private JPanel pnl1,pnl2,pnl3,pnl4;
	private JRadioButton rb1[];
	private ButtonGroup bg1;
	private JLabel lbl1,lbl3;
	private JButton btn2,btn4;
	private JTextField tf2,tf3;
	
	public static int maxOvers,target;
	
	public Frame3() {
		initializeComponents();
		addComponents();
		addListeners();
		
		f.pack();
		f.setVisible(true);
	}
	
	public void initializeComponents() {
		f = new JFrame("Overs and Target Selection");
		
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		pnl3 = new JPanel();
		pnl4 = new JPanel();
		
		rb1 = new JRadioButton[5];
		rb1[0] = new JRadioButton("02");
		rb1[1] = new JRadioButton("05");
		rb1[2] = new JRadioButton("10");
		rb1[3] = new JRadioButton("15");
		rb1[4] = new JRadioButton("20");
		
		bg1 = new ButtonGroup();
		
		lbl1 = new JLabel("Select Overs-");
		lbl3 = new JLabel("Equation is-");
		
		btn2 = new JButton("Get Target");
		
		tf2 = new JTextField("---");
		tf3 = new JTextField("---");
		btn4 = new JButton("Start Chasing");
	}
	
	public void addComponents() {
		for(int i = 0; i < 5; i++)	bg1.add(rb1[i]);
		
		tf2.setEditable(false);tf2.setBackground(Color.gray);
		tf3.setEditable(false);tf3.setBackground(Color.gray);
		
		pnl1.add(lbl1);
		for(int i = 0; i < 5; i++)	pnl1.add(rb1[i]);
		
		pnl2.add(btn2);
		pnl2.add(tf2);
		
		pnl3.add(lbl3);
		pnl3.add(tf3);
		
		pnl4.add(btn4);
		
		f.add(pnl1);
		f.add(pnl2);
		f.add(pnl3);
		f.add(pnl4);
		
		pnl2.setLayout(new GridLayout(1,2));
		pnl3.setLayout(new GridLayout(1,2));
		f.setLayout(new GridLayout(4,1,10,10));
	}
	
	public void addListeners() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
			
				int i = 0;
				
				while(!rb1[i].isSelected() && i < 5)	i++;
				
				if(i == 5)	tf2.setText("X not selected overs X");
				else {
					switch(i) {
					case 0 : maxOvers = 2;break;
					case 1 : maxOvers = 5;break;
					case 2 : maxOvers = 10;break;
					case 3 : maxOvers = 15;break;
					case 4 : maxOvers = 20;break;
					}
					
					target = maxOvers * (6 + r.nextInt(9));
					
					tf2.setText("Your target is - "+target);
					tf3.setText("Need "+target+" runs in "+(maxOvers*6)+" balls");
				}
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TestPlay();
				f.setVisible(false);
			}
		});
	}
	
}
