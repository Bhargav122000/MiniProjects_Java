import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TestPlay {
	
	private JFrame f;
	private JPanel pnl1,pnl2,pnl3,pnl4;
	private JLabel lbl1[],lbl2,lbl3[],lbl4;
	private JTextField tf1[],tf3[],tf4;
	private JButton btn2[],btn4;
	
	private int striker,nonStriker;
	public static int score,wickets,overs,balls;
	private Boolean [] batStatus;
	public static int [] runs;
	public static int [] faced;
	private JDialog d;
	private JList<String> l;
	private JButton btnd;
	
	Random r = new Random();
	
	public TestPlay() {

		initializeComponents();
		addComponents();
		addListeners();
		
		f.pack();
		f.setVisible(true);
	}
	
	public void initializeComponents() {

		f = new JFrame("Test Play");
		
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		pnl3 = new JPanel();
		pnl4 = new JPanel();
		
		lbl1 = new JLabel[2];
		lbl1[0] = new JLabel("Target-");
		lbl1[1] = new JLabel("Max.Overs-");
		
		lbl2 = new JLabel("Your Score-");
		
		lbl3 = new JLabel[4];
		lbl3[0] = new JLabel("Striker-");
		lbl3[1] = new JLabel("Non-Striker-");
		lbl3[2] = new JLabel("Score-");
		lbl3[3] = new JLabel("Overs-");
		
		lbl4 = new JLabel("Match Status-");
		
		tf1 = new JTextField[2];
		tf1[0] = new JTextField("---");
		tf1[1] = new JTextField("---");
		
		tf3 = new JTextField[4];
		tf3[0] = new JTextField("---");
		tf3[1] = new JTextField("---");
		tf3[2] = new JTextField("---");
		tf3[3] = new JTextField("---");
		
		tf4 = new JTextField("---");
		
		btn2 = new JButton[7];
		btn2[0] = new JButton("00");
		btn2[1] = new JButton("01");
		btn2[2] = new JButton("02");
		btn2[3] = new JButton("03");
		btn2[4] = new JButton("04");
		btn2[5] = new JButton("05");
		btn2[6] = new JButton("06");
		btn4 = new JButton("Display ScoreCard");
		
		d = new JDialog(f,"chose");
		
		btnd = new JButton("submit");
		
		l = new JList<String>(Frame1.players[Frame1.userTeam]);
		
		striker = 0;
		nonStriker = 1;
		overs = 0;
		balls = 0;
		wickets = 0;
		score = 0;
		batStatus = new Boolean[] {true,true,false,false,false,false,false,false,false,false,false};
		runs = new int[] {0,0,0,0,0,0,0,0,0,0,0};
		faced = new int[] {0,0,0,0,0,0,0,0,0,0,0};
		
		tf1[0].setText(" "+Frame3.target);
		tf1[1].setText(" "+Frame3.maxOvers);
		tf3[0].setText(Frame1.players[Frame1.userTeam][striker]);
		tf3[1].setText(Frame1.players[Frame1.userTeam][nonStriker]);
		tf3[2].setText(" "+score+"/"+wickets);
		tf3[3].setText(" "+overs+"."+balls);
		
	}
	
	public void addComponents() {
		
		tf1[0].setEditable(false);tf1[0].setBackground(Color.gray);
		tf1[1].setEditable(false);tf1[1].setBackground(Color.gray);
		tf3[0].setEditable(false);tf3[0].setBackground(Color.gray);
		tf3[1].setEditable(false);tf3[1].setBackground(Color.gray);
		tf3[2].setEditable(false);tf3[2].setBackground(Color.gray);
		tf3[3].setEditable(false);tf3[3].setBackground(Color.gray);
		tf4.setEditable(false);tf4.setBackground(Color.gray);
		
		pnl1.add(lbl1[0]);
		pnl1.add(tf1[0]);
		pnl1.add(lbl1[1]);
		pnl1.add(tf1[1]);
		
		pnl2.add(lbl2);
		for(int i = 0; i < 7; i++)	pnl2.add(btn2[i]);
		
		for(int i = 0; i < 4; i++) {
			pnl3.add(lbl3[i]);
			pnl3.add(tf3[i]);
		}
		
		pnl4.add(lbl4);
		pnl4.add(tf4);
		pnl4.add(btn4);
		
		f.add(pnl1);
		f.add(pnl2);
		f.add(pnl3);
		f.add(pnl4);
		
		d.add(l);
		d.add(btnd);
		
		pnl1.setLayout(new FlowLayout());
		pnl2.setLayout(new FlowLayout());
		pnl3.setLayout(new GridLayout(2,2));
		pnl4.setLayout(new GridLayout(2,2));
		f.setLayout(new GridLayout(4,1,10,10));
		
		d.setLayout(new FlowLayout());
		d.setSize(300,300);
	}
	
	public void addListeners() {
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn2[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int o = r.nextInt(7);
				int t;
				
				if(score < Frame3.target && overs < Frame3.maxOvers && wickets < 10) {
					
					faced[striker]++;
					
					if(o == 0) {
						d.setVisible(true);
						wickets++;
						if(wickets == 10) {
							tf4.setText("All-OUT!!");
						}
					}
					
					if(balls == 5) {
						balls = 0;
						overs++;
						t = striker;
						striker = nonStriker;
						nonStriker = t;
					}
					else	balls++;
					
					if(overs == Frame3.maxOvers) {
						tf4.setText("Overs are done");
					}
					
					tf3[0].setText(Frame1.players[Frame1.userTeam][striker]);
					tf3[1].setText(Frame1.players[Frame1.userTeam][nonStriker]);
					tf3[2].setText(" "+score+"/"+wickets);
					tf3[3].setText(" "+overs+"."+balls);
				}
			}
		});
		
		btn2[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int o = r.nextInt();
				int t;
				
				if(score < Frame3.target && overs < Frame3.maxOvers && wickets < 10) {
					
					faced[striker]++;
					
					if(o == 1) {
						d.setVisible(true);
						wickets++;
						if(wickets == 10) {
							tf4.setText("All-OUT!!");
						}
					}
					else {
						score += 1;
						runs[striker] += 1;
						t = striker;
						striker = nonStriker;
						nonStriker = t;
						if(score >= Frame3.target) {
							tf4.setText("You won the match");
						}
					}
					
					if(balls == 5) {
						balls = 0;
						overs++;
						t = striker;
						striker = nonStriker;
						nonStriker = t;
					}
					else	balls++;
					
					if(overs == Frame3.maxOvers) {
						tf4.setText("Overs are done");
					}
					
					tf3[0].setText(Frame1.players[Frame1.userTeam][striker]);
					tf3[1].setText(Frame1.players[Frame1.userTeam][nonStriker]);
					tf3[2].setText(" "+score+"/"+wickets);
					tf3[3].setText(" "+overs+"."+balls);

				}
	
			}
		});
		
		btn2[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int o = r.nextInt(7);
				int t;
				
				if(score < Frame3.target && overs < Frame3.maxOvers && wickets < 10) {
					
					faced[striker]++;
					
					if(o == 2) {
						d.setVisible(true);
						wickets++;
						if(wickets == 10) {
							tf4.setText("All-OUT!!");
						}
					}
					else {
						score += 2;
						runs[striker] += 2;
						
						if(score >= Frame3.target) {
							tf4.setText("You won the match");
						}
					}
					
					if(balls == 5) {
						balls = 0;
						overs++;
						t = striker;
						striker = nonStriker;
						nonStriker = t;
					}
					else	balls++;
					
					if(overs == Frame3.maxOvers) {
						tf4.setText("Overs are done");
					}
					
					tf3[0].setText(Frame1.players[Frame1.userTeam][striker]);
					tf3[1].setText(Frame1.players[Frame1.userTeam][nonStriker]);
					tf3[2].setText(" "+score+"/"+wickets);
					tf3[3].setText(" "+overs+"."+balls);

				}
			}
		});
		
		btn2[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int o = r.nextInt();
				int t;
				
				if(score < Frame3.target && overs < Frame3.maxOvers && wickets < 10) {
				
					faced[striker]++;
					
					if(o == 3) {
						d.setVisible(true);
						wickets++;
						if(wickets == 10) {
							tf4.setText("All-OUT!!");
						}
					}
					else {
						score += 3;
						runs[striker] += 3;
						t = striker;
						striker = nonStriker;
						nonStriker = t;
						if(score >= Frame3.target) {
							tf4.setText("You won the match");
						}
					}
					
					if(balls == 5) {
						balls = 0;
						overs++;
						t = striker;
						striker = nonStriker;
						nonStriker = t;
					}
					else	balls++;
					
					if(overs == Frame3.maxOvers) {
						tf4.setText("Overs are done");
					}
					
					tf3[0].setText(Frame1.players[Frame1.userTeam][striker]);
					tf3[1].setText(Frame1.players[Frame1.userTeam][nonStriker]);
					tf3[2].setText(" "+score+"/"+wickets);
					tf3[3].setText(" "+overs+"."+balls);

				}
			}
		});
		
		btn2[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int o = r.nextInt(7);
				int t;
				
				if(score < Frame3.target && overs < Frame3.maxOvers && wickets < 10) {
					
					faced[striker]++;
					
					if(o == 4) {
						d.setVisible(true);
						wickets++;
						if(wickets == 10) {
							tf4.setText("All-OUT!!");
						}
					}
					else {
						score += 4;
						runs[striker] += 4;
						
						if(score >= Frame3.target) {
							tf4.setText("You won the match");
						}
					}
					
					if(balls == 5) {
						balls = 0;
						overs++;
						t = striker;
						striker = nonStriker;
						nonStriker = t;
					}
					else	balls++;
					
					if(overs == Frame3.maxOvers) {
						tf4.setText("Overs are done");
					}
					
					tf3[0].setText(Frame1.players[Frame1.userTeam][striker]);
					tf3[1].setText(Frame1.players[Frame1.userTeam][nonStriker]);
					tf3[2].setText(" "+score+"/"+wickets);
					tf3[3].setText(" "+overs+"."+balls);
				}
			}
		});


		btn2[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int o = r.nextInt();
				int t;
				
				if(score < Frame3.target && overs < Frame3.maxOvers && wickets < 10) {
					
					faced[striker]++;
					
					if(o == 5) {
						d.setVisible(true);
						wickets++;
						if(wickets == 10) {
							tf4.setText("All-OUT!!");
						}
					}
					else {
						score += 5;
						runs[striker] += 5;
						t = striker;
						striker = nonStriker;
						nonStriker = t;
						if(score >= Frame3.target) {
							tf4.setText("You won the match");
						}
					}
					
					if(balls == 5) {
						balls = 0;
						overs++;
						t = striker;
						striker = nonStriker;
						nonStriker = t;
					}
					else	balls++;
					
					if(overs == Frame3.maxOvers) {
						tf4.setText("Overs are done");
					}
					
					tf3[0].setText(Frame1.players[Frame1.userTeam][striker]);
					tf3[1].setText(Frame1.players[Frame1.userTeam][nonStriker]);
					tf3[2].setText(" "+score+"/"+wickets);
					tf3[3].setText(" "+overs+"."+balls);

				}
			}
		});

		btn2[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int o = r.nextInt(7);
				int t;
				
				if(score < Frame3.target && overs < Frame3.maxOvers && wickets < 10) {
					
					faced[striker]++;
					
					if(o == 6) {
						d.setVisible(true);
						wickets++;
						if(wickets == 10) {
							tf4.setText("All-OUT!!");
						}
					}
					else {
						score += 6;
						runs[striker] += 6;
						
						if(score >= Frame3.target) {
							tf4.setText("You won the match");
						}
					}
					
					if(balls == 5) {
						balls = 0;
						overs++;
						t = striker;
						striker = nonStriker;
						nonStriker = t;
					}
					else	balls++;
					
					if(overs == Frame3.maxOvers) {
						tf4.setText("Overs are done");
					}
					
					tf3[0].setText(Frame1.players[Frame1.userTeam][striker]);
					tf3[1].setText(Frame1.players[Frame1.userTeam][nonStriker]);
					tf3[2].setText(" "+score+"/"+wickets);
					tf3[3].setText(" "+overs+"."+balls);

				}
			}
		});

		
		btnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = l.getSelectedIndex();
				if(!batStatus[i]) {		
					batStatus[i] = true;
					striker = i;
					tf3[0].setText(Frame1.players[Frame1.userTeam][striker]);
					tf3[1].setText(Frame1.players[Frame1.userTeam][nonStriker]);
					d.setVisible(false);
				}
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Scorecard();
				f.setVisible(false);
			}
		});
	}
	
}
