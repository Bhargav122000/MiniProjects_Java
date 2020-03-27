import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Scorecard {

	private JFrame f;
	private JPanel pnl1,pnl2,pnl3,pnl4,pnl5,pnl6;
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl6[];
	private JTextField tf1[],tf2[],tf3[],tf4[],tf6[];
	private JButton btn6;
	
	private Double [] strikeRate;
	private int i;
	
	private static DecimalFormat df2 = new DecimalFormat("###.##");
	
	public Scorecard() {
		
		initializeComponents();
		addComponents();
		addListeners();
		
		f.pack();
		f.setVisible(true);
		
	}
	
	public void initializeComponents() {
		
		strikeRate = new Double[11];
		for(i = 0; i < 11; i++) {
			if(TestPlay.runs[i] != 0 && TestPlay.faced[i] != 0)
				strikeRate[i] = Double.valueOf(TestPlay.runs[i]*100)/TestPlay.faced[i];
			else
				strikeRate[i] = 0.00;
		}
			
		f = new JFrame("Match Scorecard");
		
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		pnl3 = new JPanel();
		pnl4 = new JPanel();
		pnl5 = new JPanel();
		pnl6 = new JPanel();
		
		lbl1 = new JLabel("Player");
		tf1 = new JTextField[11];
		for(i = 0; i < 11; i++)
			tf1[i] = new JTextField(Frame1.players[Frame1.userTeam][i],15);		
		lbl2 = new JLabel("Runs");
		tf2 = new JTextField[11];
		for(i = 0; i < 11; i++)
			tf2[i] = new JTextField(" "+TestPlay.runs[i]);
		lbl3 = new JLabel("Balls Faced");
		tf3 = new JTextField[11];
		for(i = 0; i < 11; i++)
			tf3[i] = new JTextField(" "+TestPlay.faced[i]);
		lbl4 = new JLabel("StrikeRate");
		tf4 = new JTextField[11];
		for(i = 0; i < 11; i++)
			tf4[i] = new JTextField(" "+df2.format(strikeRate[i]));
		lbl6 = new JLabel[3];
		lbl6[0] = new JLabel("Summary-");
		lbl6[1] = new JLabel("Top Score-");
		lbl6[2] = new JLabel("Best StrikeRate-");
		
		tf6 = new JTextField[3];
		for(i = 0; i < 3; i++)	tf6[i] = new JTextField(30);
		
		btn6 = new JButton("Finish the match");
		
		this.displayTextFields();
	}
	
	public void addComponents() {
		
		for(i = 0; i < 11; i++)	{
			tf1[i].setEditable(false);
			tf1[i].setBackground(Color.gray);
		}
		for(i = 0; i < 11; i++)	{
			tf2[i].setEditable(false);
			tf2[i].setBackground(Color.gray);
		}
		for(i = 0; i < 11; i++)	{
			tf3[i].setEditable(false);
			tf3[i].setBackground(Color.gray);
		}
		for(i = 0; i < 11; i++)	{
			tf4[i].setEditable(false);
			tf4[i].setBackground(Color.gray);
		}
		
		tf6[0].setEditable(false);tf6[0].setBackground(Color.gray);
		tf6[1].setEditable(false);tf6[1].setBackground(Color.gray);
		tf6[2].setEditable(false);tf6[2].setBackground(Color.gray);
		
		pnl1.add(lbl1);
		for(i = 0; i < 11; i++)	pnl1.add(tf1[i]);
		pnl2.add(lbl2);
		for(i = 0; i < 11; i++)	pnl2.add(tf2[i]);
		pnl3.add(lbl3);
		for(i = 0; i < 11; i++)	pnl3.add(tf3[i]);
		pnl4.add(lbl4);
		for(i = 0; i < 11; i++) pnl4.add(tf4[i]);
		
		pnl5.add(pnl1);
		pnl5.add(pnl2);
		pnl5.add(pnl3);
		pnl5.add(pnl4);
		
		for(i = 0; i < 3;i++) {
			pnl6.add(lbl6[i]);
			pnl6.add(tf6[i]);
		}
		pnl6.add(btn6);
		
		f.add(pnl5);
		f.add(pnl6);
		
		pnl1.setLayout(new GridLayout(12,1,10,0));
		pnl2.setLayout(new GridLayout(12,1,10,0));
		pnl3.setLayout(new GridLayout(12,1,10,0));
		pnl4.setLayout(new GridLayout(12,1,10,0));
		pnl5.setLayout(new GridLayout(1,4));
		pnl6.setLayout(new GridLayout(4,2,10,10));
		
		f.setLayout(new GridLayout(2,1,20,0));
	}
	
	public void addListeners() {
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void displayTextFields() {
		int i,j,k;
		
		if(TestPlay.score >= Frame3.target && TestPlay.overs <= Frame3.maxOvers) {
			j = 10-TestPlay.wickets;
			k = (Frame3.maxOvers - TestPlay.overs)*6 - TestPlay.balls;
			tf6[0].setText("Won match by "+k+" balls remaining & "+j+" wickets in hand");
		}
		else if(TestPlay.score < Frame3.target) {
				j = Frame3.target - TestPlay.score - 1;
				tf6[0].setText("Lost match by "+j+" runs");
		}
		
		int max = 0;
		for(i = 1; i < 11; i++)
			if(TestPlay.runs[i] > TestPlay.runs[max])
				max = i;
		tf6[1].setText(" "+TestPlay.runs[max]+" runs by "+Frame1.players[Frame1.userTeam][max]);
		
		max = 0;
		for(i = 1; i < 11; i++)
			if(strikeRate[i] > strikeRate[max])
				max = i;
		tf6[2].setText(" "+df2.format(strikeRate[max])+" by "+Frame1.players[Frame1.userTeam][max]);
		
	}
	
}
