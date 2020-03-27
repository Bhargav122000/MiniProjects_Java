import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class WaitingTimes extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private double wt_fcfs;
	private double wt_sjf_np;
	private double wt_sjf_p;
	private double wt_pjf_np;
	private double wt_pjf_p;
	private double wt_rrs;
	private double avg_t;
	
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
	private JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	private JButton btn;
	
	public WaitingTimes() {
		super();
		initialise();
		add();
		register();
		
		pack();
		setVisible(true);
	}
	
	public void initialise() {
		lbl1 = new JLabel("FCFS");
		lbl2 = new JLabel("SJF(NP)");
		lbl3 = new JLabel("SJF(P)");
		lbl4 = new JLabel("PJF(NP)");
		lbl5 = new JLabel("PJF(P)");
		lbl6 = new JLabel("RRS");
		lbl7 = new JLabel("Scale-");
		
		tf1 = new JTextField(2);	tf1.setBackground(Color.MAGENTA);
		tf2 = new JTextField(2);	tf2.setBackground(Color.GRAY);
		tf3 = new JTextField(2);	tf3.setBackground(Color.YELLOW);
		tf4 = new JTextField(2);	tf4.setBackground(Color.RED);
		tf5 = new JTextField(2);	tf5.setBackground(Color.GREEN);
		tf6 = new JTextField(2);	tf6.setBackground(Color.ORANGE);
		tf7 = new JTextField(3);
		
		btn = new JButton("Close");
	}
	
	public void add() {
		add(lbl1);add(tf1);
		add(lbl2);add(tf2);
		add(lbl3);add(tf3);
		add(lbl4);add(tf4);
		add(lbl5);add(tf5);
		add(lbl6);add(tf6);
		add(btn);
		add(lbl7);add(tf7);
		
		this.setLayout(new FlowLayout());

	}
	
	public void register() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	
	public int getScale() {
		
		if(tf7.getText().length() > 0)		return (Integer.parseInt(tf7.getText()));
		else {
			wt_fcfs = FCFS.avg_wt;
			wt_sjf_np = SJF_NP.avg_wt;
			wt_sjf_p = SJF_P.avg_wt;
			wt_pjf_np = PJF_NP.avg_wt;
			wt_pjf_p = PJF_P.avg_wt;
			wt_rrs = RRS.avg_wt;
			
			avg_t = Math.round((wt_fcfs + wt_sjf_np + wt_sjf_p + wt_pjf_np + wt_pjf_p + wt_rrs)/(double)6);
			if(avg_t <= 50) {
				return 100;
			}
			else if(avg_t <= 100) {
				return 75;
			}
			else {
				return 25;
			}
		}
	}
	
	public void draw(int scale,Graphics g) {
		
		g.fillRect(50,200,1,300);
		
		g.setColor(Color.MAGENTA);
		g.fillRect(51,225,(scale*(int)wt_fcfs),10);
		g.setColor(Color.GRAY);
		g.fillRect(51,275,(scale*(int)wt_sjf_np),10);
		g.setColor(Color.YELLOW);
		g.fillRect(51,325,(scale*(int)wt_sjf_p),10);
		g.setColor(Color.RED);
		g.fillRect(51,375,(scale*(int)wt_pjf_np),10);
		g.setColor(Color.GREEN);
		g.fillRect(51,425,(scale*(int)wt_pjf_p),10);
		g.setColor(Color.ORANGE);
		g.fillRect(51,475,(scale*(int)wt_rrs),10);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		int scale = getScale();
		tf7.setText(Integer.toString(scale));
		
		draw(scale,g);
		
	}
}
