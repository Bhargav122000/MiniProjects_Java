import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Demo {
	private JFrame f;
	private JLabel lbl1,lbl2,lbl3;
	private JLabel lbl_p,lbl_q;
	private JTextField tf1[],tf2[];
	private JTextField tf_p[],tf_q;
	private JButton btn1;
	private JRadioButton rb1[];
	private ButtonGroup bg1;
	private JPanel pnl1,pnl2,pnl3,pnl4;
	private JPanel pnl5;
	int i,j,k,n;
	int quantum;
	int at[],bt[],p[];
	static int select = -1;
	
	public Demo() {
		initialize();
		place();
		register();
		
		f.pack();
		f.setVisible(true);
	}
	
	public void initialize() {
		n = 5;
		
		at = new int[n];
		bt = new int[n];
		
		
		f = new JFrame("Demo");
		
		lbl1 = new JLabel("Enter arrival times:");
		lbl2 = new JLabel("Enter burst times:");
		lbl3 = new JLabel("Choose a scheduling algo:");
		
		tf1 = new JTextField[n];
		tf2 = new JTextField[n];
		for(i=0;i<n;i++) {
			tf1[i] = new JTextField(3);
			tf2[i] = new JTextField(3);
		}
		
		btn1 = new JButton("Submit");
		
		rb1 = new JRadioButton[6];
		rb1[0] = new JRadioButton("FCFS",true);
		rb1[1] = new JRadioButton("SJF(NP)",false);
		rb1[2] = new JRadioButton("SJF(P)",false);
		rb1[3] = new JRadioButton("PJF(NP)",false);
		rb1[4] = new JRadioButton("PJF(P)",false);
		rb1[5] = new JRadioButton("RRS",false);
		
		bg1 = new ButtonGroup();
		for(i=0;i<6;i++) 	bg1.add(rb1[i]);
		
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		pnl3 = new JPanel();
		pnl4 = new JPanel();
	}
	
	public void place() {
		pnl1.add(lbl1);
		for(i=0;i<n;i++)	pnl1.add(tf1[i]);
		pnl2.add(lbl2);
		for(i=0;i<n;i++)	pnl2.add(tf2[i]);
		pnl3.add(lbl3);
		for(i=0;i<6;i++)	pnl3.add(rb1[i]);
		pnl4.add(btn1);
		
		f.add(pnl3);
		f.add(pnl1);
		f.add(pnl2);
		f.add(pnl4);
		
		pnl3.setLayout(new FlowLayout());
		pnl1.setLayout(new FlowLayout());
		pnl2.setLayout(new FlowLayout());
		pnl4.setLayout(new FlowLayout());
		f.setLayout(new GridLayout(4,1));
	}
	
	public void register() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(i=0;i<n;i++) {
					at[i] = Integer.parseInt(tf1[i].getText());
					bt[i] = Integer.parseInt(tf2[i].getText());
				}
				if(rb1[0].isSelected())		new FCFS(at,bt);
				else if(rb1[1].isSelected())	new SJF_NP(at,bt);
				else if(rb1[2].isSelected())	new SJF_P(at,bt);
				else if(rb1[3].isSelected()){
					p = new int[n];
					for(i=0;i<n;i++)	p[i] = Integer.parseInt(tf_p[i].getText());
					new PJF_NP(at,bt,p);
				}
				else if(rb1[4].isSelected()){
					p = new int[n];
					for(i=0;i<n;i++)	p[i] = Integer.parseInt(tf_p[i].getText());
					new PJF_P(at,bt,p);
				}
				else if(rb1[5].isSelected()) {
					quantum = Integer.parseInt(tf_q.getText());
					new RRS(at,bt,quantum);
				}
				
				f.setVisible(false);
			}
		});
		
		rb1[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(select == 3|| select == 4 || select == 5) {
					f.setVisible(false);
					f.remove(pnl5);
					f.setLayout(new GridLayout(4,1));
					f.pack();
					f.setVisible(true);
				}
				select = 0;
			}
		});
		
		rb1[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(select == 3|| select == 4 || select == 5) {
					f.setVisible(false);
					f.remove(pnl5);
					f.setLayout(new GridLayout(4,1));
					f.pack();
					f.setVisible(true);
				}
				select = 1;
			}
		});
		
		rb1[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(select == 3|| select == 4 || select == 5) {
					f.setVisible(false);
					f.remove(pnl5);
					f.setLayout(new GridLayout(4,1));
					f.pack();
					f.setVisible(true);
				}
				select = 2;
			}
		});
		
		rb1[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rb1[3].isSelected()) {
					if(select != 3 && select != 4) {
						if(select == 5) {
							f.setVisible(false);
							f.remove(pnl5);
							f.setLayout(new GridLayout(4,1));
						}
						
						lbl_p = new JLabel("Enter priorities:");
						tf_p = new JTextField[n];
						for(i=0;i<n;i++)	tf_p[i] = new JTextField(5);
						pnl5 = new JPanel();
						
						pnl5.add(lbl_p);
						for(i=0;i<n;i++)	pnl5.add(tf_p[i]);
						
						f.remove(pnl4);
						f.add(pnl5);
						f.add(pnl4);
						
						f.setLayout(new GridLayout(5,1));
						f.pack();
						f.setVisible(true);
					}
					select = 3;
				}
			}
		});
		
		rb1[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rb1[4].isSelected()) {
					if(select != 3 && select != 4) {
						if(select == 5) {
							f.setVisible(false);
							f.remove(pnl5);
							f.setLayout(new GridLayout(4,1));
						}
						
						lbl_p = new JLabel("Enter priorities:");
						tf_p = new JTextField[n];
						for(i=0;i<n;i++)	tf_p[i] = new JTextField(5);
						pnl5 = new JPanel();
						
						pnl5.add(lbl_p);
						for(i=0;i<n;i++)	pnl5.add(tf_p[i]);
						
						f.remove(pnl4);
						f.add(pnl5);
						f.add(pnl4);
						
						f.setLayout(new GridLayout(5,1));
						f.pack();
						f.setVisible(true);
					}
					select = 4;
				}
			}
		});
		
		rb1[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rb1[5].isSelected()) {
					if(select != 5) {
						if(select == 3 || select == 4) {
							f.setVisible(false);
							f.remove(pnl5);
							f.setLayout(new GridLayout(4,1));
						}
						
						lbl_q = new JLabel("Enter Time Quantum:");
						tf_q = new JTextField(5);
						
						pnl5 = new JPanel();
						
						pnl5.add(lbl_q);
						pnl5.add(tf_q);
						
						f.remove(pnl4);
						f.add(pnl5);
						f.add(pnl4);
						
						f.setLayout(new GridLayout(5,1));
						f.pack();
						f.setVisible(true);
					}
					select = 5;	
				}
			}
		});
	}
	
	public static void main(String []args) {
		new Demo();
	}
}
