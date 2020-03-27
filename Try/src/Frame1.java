import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame1 {
	private JFrame f;
	private JPanel pnl1,pnl2,pnl3,pnl4;
	private JLabel lbl2,lbl3,lbl4[];
	private JRadioButton rb2[];
	private ButtonGroup bg2;
	private JButton btn2,btn4;
	private JTextField tf3[],tf4[];
	
	public static String team[];
	public static String players[][];
	private int i,j;
	public static int userTeam;
	
	public Frame1() {
		
		initializeComponents();
		addComponents();
		addListeners();
		
		f.pack();
		f.setSize(1000,600);
		f.setVisible(true);
		
	}
	
	public void initializeComponents() {
		
		team = new String[8];
		team[0] = "India";
		team[1] ="Australia";
		team[2] = "England";
		team[3] = "NewZeaLand";
		team[4] = "SouthAfrica";
		team[5] = "Pakistan";
		team[6] = "SriLanka";
		team[7] = "Bangladesh";
		
		players = new String[8][11];
		
		players[0][0] = "Rohit";players[0][1] = "Dhawan";
		players[0][2] = "Virat"; players[0][3] = "Rahul";
		players[0][4] = "Rishabh";players[0][5] = "Hardik";
		players[0][6] = "Jadeja"; players[0][7] = "Kuldeep";
		players[0][8] = "Shami"; players[0][9] = "Bhuvneswar";
		players[0][10] = "Bumrah";
		
		players[1][0] = "Finch";players[1][1] = "Warner";
		players[1][2] = "Smith"; players[1][3] = "Labuschagne";
		players[1][4] = "Carey";players[1][5] = "Stoinis";
		players[1][6] = "Maxwell"; players[1][7] = "Cummins";
		players[1][8] = "Starc"; players[1][9] = "Hazlewood";
		players[1][10] = "Lyon";
		
		players[2][0] = "Roy";players[2][1] = "Bairstow";
		players[2][2] = "Root"; players[2][3] = "Morgan";
		players[2][4] = "Buttler";players[2][5] = "Stokes";
		players[2][6] = "Moeen"; players[2][7] = "Woakes";
		players[2][8] = "Rashid"; players[2][9] = "Wood";
		players[2][10] = "Archer";
		
		players[3][0] = "Guptil";players[3][1] = "Watling";
		players[3][2] = "Williamson";players[3][3] = "Taylor";
		players[3][4] = "Latham";players[3][5] = "de Grandhomme";
		players[3][6] = "Santner"; players[3][7] = "Southee";
		players[3][8] = "Boult"; players[3][9] = "Ferguson";
		players[3][10] = "Wagner";
		
		players[4][0] = "Markram";players[4][1] = "Amla";
		players[4][2] = "du Plessis"; players[4][3] = "van der Dussen";
		players[4][4] = "de Kock";players[4][5] = "Duminy";
		players[4][6] = "Phehlukwayo"; players[4][7] = "Morris";
		players[4][8] = "Rabada"; players[4][9] = "Ngidi";
		players[4][10] = "Tahir";
		
		players[5][0] = "Fakhar";players[5][1] = "Imam";
		players[5][2] = "Babar"; players[5][3] = "Haris";
		players[5][4] = "Sarfaraz";players[5][5] = "Imad";
		players[5][6] = "Shadab"; players[5][7] = "Wahab";
		players[5][8] = "Junaid"; players[5][9] = "Shaheen";
		players[5][10] = "Amir";
		
		players[6][0] = "Karunaratne";players[6][1] = "Avishka";
		players[6][2] = "Thirimanne"; players[6][3] = "Kusal Mendis";
		players[6][4] = "Kusal Perera";players[6][5] = "Angelo Mathews";
		players[6][6] = "de Silva"; players[6][7] = "Udana";
		players[6][8] = "Lakmal"; players[6][9] = "Rajitha";
		players[6][10] = "Malinga";
		
		players[7][0] = "Tamim";players[7][1] = "Soumya Sarkar";
		players[7][2] = "Liton Das"; players[7][3] = "Mahmudullah";
		players[7][4] = "Mushfiqur";players[7][5] = "Shakid";
		players[7][6] = "Mehidy Hasan"; players[7][7] = "Mashrafe";
		players[7][8] = "Saifuddin"; players[7][9] = "Mustafizur";
		players[7][10] = "Rubel";
		
		f = new JFrame("Your Team Selection");
		
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		pnl3 = new JPanel();
		pnl4 = new JPanel();
		
		lbl2 = new JLabel("Select your Team-");
		lbl3 = new JLabel("Your Team-");
		lbl4 = new JLabel[4];
		lbl4[0] = new JLabel("Batsmen of your team-");
		lbl4[1] = new JLabel("Keeper of your team-");
		lbl4[2] = new JLabel("All Rounders of your team-");
		lbl4[3] = new JLabel("Bowlers of your team-");
		
		rb2 = new JRadioButton[8];
		for(i = 0; i < 8; i++)	rb2[i] = new JRadioButton(team[i]);
		
		bg2 = new ButtonGroup();
		
		btn2 = new JButton("Submit");
		btn4 = new JButton("Next");
		
		tf3 = new JTextField[11];
		for(i = 0; i < 11; i++)	
			tf3[i] = new JTextField("---");
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
				
				for(i = 0; i < 8; i++)
					if(rb2[i].isSelected())
						break;
				
				userTeam = i;
				
				for(j = 0; j < 11; j++)	tf3[j].setText(players[i][j]);
					
				tf4[0].setText(players[i][0]+","+players[i][1]+","+players[i][2]+","+players[i][3]);
				tf4[1].setText(players[i][4]);
				tf4[2].setText(players[i][5]+","+players[i][6]);
				tf4[3].setText(players[i][7]+","+players[i][8]+","+players[i][9]+","+players[i][10]);
				tf4[4].setText("Successfully selected!!");
				
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
