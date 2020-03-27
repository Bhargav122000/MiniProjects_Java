import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame2 {
	private JFrame f;
	private JPanel pnl1,pnl2,pnl3,pnl4;
	private JLabel lbl2,lbl3,lbl4[];
	private JRadioButton rb2[];
	private ButtonGroup bg2;
	private JButton btn2,btn4;
	private JTextField tf3[],tf4[];
	
	private int i,j;
	public static int oppTeam = -1;
	
	public Frame2() {
		
		initializeComponents();
		addComponents();
		addListeners();
		
		f.pack();
		f.setSize(1000,600);
		f.setVisible(true);
	}
	
	public void initializeComponents() {
		
		f = new JFrame("Your Opposition Selection");
		
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		pnl3 = new JPanel();
		pnl4 = new JPanel();
		
		lbl2 = new JLabel("Select Opposition Team-");
		
		lbl3 = new JLabel("Opposition Team -");
		
		lbl4 = new JLabel[4];
		lbl4[0] = new JLabel("Batsmen of opp.team-");
		lbl4[1] = new JLabel("Keeper of opp.team-");
		lbl4[2] = new JLabel("All Rounders of opp.team-");
		lbl4[3] = new JLabel("Bowlers of opp.team-");
		
		rb2 = new JRadioButton[8];
		for(i = 0; i < 8; i++)	rb2[i] = new JRadioButton(Frame1.team[i]);
		
		bg2 = new ButtonGroup();
		
		btn2 = new JButton("Submit");
		btn4 = new JButton("Next");
		
		tf3 = new JTextField[11];
		for(i = 0; i < 11; i++)	tf3[i] = new JTextField("---");
		tf4 = new JTextField[5];
		tf4[0] = new JTextField("1,2,3,4",20);
		tf4[1] = new JTextField("5",20);
		tf4[2] = new JTextField("6,7",20);
		tf4[3] = new JTextField("8,9,10,11",20);
		tf4[4] = new JTextField("---",20);
		
	}
	
	public void addComponents() {
		
		for(i = 0; i < 11; i++) {
			tf3[i].setEditable(false);
			tf3[i].setBackground(Color.gray);
		}
		for(i = 0; i < 5; i++)	{
			tf4[i].setEditable(false);
			tf4[i].setBackground(Color.gray);
		}
		
		for(i = 0; i < 8; i++)	bg2.add(rb2[i]);
		
		pnl2.add(lbl2);
		for(i = 0; i < 8; i++)	pnl2.add(rb2[i]);
		pnl2.add(btn2);
		
		pnl3.add(lbl3);
		pnl3.add(tf3[3]);pnl3.add(tf3[7]);
		pnl3.add(tf3[0]);pnl3.add(tf3[4]);
		pnl3.add(tf3[8]);pnl3.add(tf3[1]);
		pnl3.add(tf3[5]);pnl3.add(tf3[9]);
		pnl3.add(tf3[2]);pnl3.add(tf3[6]);
		pnl3.add(tf3[10]);
		
		for(i = 0; i < 4; i++) {
			pnl4.add(lbl4[i]);
			pnl4.add(tf4[i]);
		}
		pnl4.add(tf4[4]);
		pnl4.add(btn4);

		pnl1.add(pnl3);
		pnl1.add(pnl4);
		
		f.add(pnl2);
		f.add(pnl1);
		
		pnl1.setLayout(new GridLayout(2,1,10,10));
		pnl2.setLayout(new GridLayout(10,1,10,10));
		pnl3.setLayout(new GridLayout(5,2,10,10));
		pnl4.setLayout(new GridLayout(6,2,10,10));
		
		f.setLayout(new GridLayout(1,2,20,20));
	}
	
	public void addListeners() {
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 0;
				
				do {
				for(i = 0; i < 8; i++)
					if(rb2[i].isSelected() == true)	
						break;
								
				if(Frame1.userTeam != i) {
					for(j = 0; j < 11; j++)	tf3[j].setText(Frame1.players[i][j]);
					
					tf4[0].setText(Frame1.players[i][0]+","+Frame1.players[i][1]+","+Frame1.players[i][2]+","+Frame1.players[i][3]);
					tf4[1].setText(Frame1.players[i][4]);
					tf4[2].setText(Frame1.players[i][5]+","+Frame1.players[i][6]);
					tf4[3].setText(Frame1.players[i][7]+","+Frame1.players[i][8]+","+Frame1.players[i][9]+","+Frame1.players[i][10]);
					tf4[4].setText("Successfully selected!!");
					
					oppTeam = i;

				}
				}while(oppTeam != -1);
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Frame3();
				f.setVisible(false);
			}
		});
	}
	
}
