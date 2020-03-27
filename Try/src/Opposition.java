import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Opposition {
	private JFrame f;
	private JPanel pnl1,pnl2,pnl3;
	private ButtonGroup bg1,bg2,bg3;
	private JRadioButton rbt[];
	private JRadioButton rbo[];
	private JRadioButton rb2,rb5,rb10,rb20,rb50;
	private JTextField tfStatus;
	private JLabel lbl1,lbl2,lbl3,lbl4;
	private JList<String> l1,l2;
	private JButton btn;
	
	private String [] teams;
	private String [][] players ;
	//private String [] ind,aus,eng,nz;
	//private String [] sa,pak,sl,ban;
	
	public Opposition() {
		initializeComponents();
		addComponents();
		addListeners();
		
		f.pack();
		f.setVisible(true);
	}
	
	public void initializeComponents() {
		int i;
		
		teams = new String[] {"India","Australia","England","NewZeaLand","SouthAfrica","Pakistan","SriLanka","Bangladesh"};
		
		players = new String[8][11];
		players[0] = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		players[1] = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		players[2] = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		players[3] = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		players[4] = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		players[5] = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		players[6] = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		players[7] = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		
		f = new JFrame("Match -");
		
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		pnl3 = new JPanel();
		
		bg1 = new ButtonGroup();
		bg2 = new ButtonGroup();
		bg3 = new ButtonGroup();
		
		rbt = new JRadioButton[8];
		for(i = 0; i < 8; i++)
			rbt[i] = new JRadioButton(teams[i]);
		rbo = new JRadioButton[8];
		for(i = 0; i < 8; i++)
			rbo[i] = new JRadioButton(teams[i]);
		rb2 = new JRadioButton("2-Over Match");
		rb5 = new JRadioButton("5-Over Match");
		rb10 = new JRadioButton("10-Over Match");
		rb20 = new JRadioButton("20-Over Match");
		rb50 = new JRadioButton("50-Over Match");
		
		tfStatus = new JTextField("---");
		tfStatus.setEditable(false);
		
		lbl1 = new JLabel("Select Team-");
		lbl2 = new JLabel("Select Opposition-");
		lbl3 = new JLabel("Your Team-");
		lbl4 = new JLabel("Your Opposition-");
		
		btn = new JButton("Submit");
	}
	
	public void addComponents() {
		int i;
		for(i = 0; i < 8; i++)
			bg1.add(rbt[i]);
		for(i = 0; i < 8; i++)
			bg2.add(rbo[i]);
		bg3.add(rb2);
		bg3.add(rb5);
		bg3.add(rb10);
		bg3.add(rb20);
		bg3.add(rb50);
		
		pnl1.add(lbl1);
		for(i = 0; i < 8; i++)
			pnl1.add(rbt[i]);
		pnl1.add(lbl2);
		for(i = 0; i < 8; i++)
			pnl1.add(rbo[i]);
		
		pnl2.add(rb2);
		pnl2.add(rb5);
		pnl2.add(rb10);
		pnl2.add(rb20);
		pnl2.add(rb50);
		pnl2.add(btn);
		pnl2.add(tfStatus);
		
		f.add(pnl1);
		f.add(pnl2);
		
		pnl1.setLayout(new GridLayout(2,9));
		pnl2.setLayout(new GridLayout(2,5));
		pnl3.setLayout(new GridLayout(2,2));
		
		f.setLayout(new GridLayout(2,1));
	}
	
	public void addListeners() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0,j = 0;	
				while(!rbt[i].isSelected())
					i++;
				l1 = new JList<String>(players[i]);
				
				while(!rbo[j].isSelected())
					j++;
				l2 = new JList<String>(players[j]);
				
				if(i == j) {
					tfStatus.setText("Try to pick up a vaild opposition team");
				}
				else {
					pnl3.add(lbl3);
					pnl3.add(l1);
					pnl3.add(lbl4);
					pnl3.add(l2);
					f.add(pnl3);
					tfStatus.setText("Successful selection is done");
				}
			}
		});
	}
	public static void main(String [] args) {
		new Opposition();
	}
}
