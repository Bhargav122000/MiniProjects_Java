import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display {
	private JFrame f;
	private JLabel lbl1,lbl2,lbl3,lbl4;
	private JTextField tf1[],tf2[],tf3[],tf4[];
	private JPanel pnl1,pnl2,pnl3,pnl4;
	int i,j,time,n;
	int ct[],tt[],wt[],gc[];
	
	public Display(int []ct,int []tt,int []wt,int []gc,int time) {
		this.ct = ct;
		this.tt = tt;
		this.wt = wt;
		this.gc = gc;
		this.time = time;
		
		initialize();
		place();
		register();
		
		f.pack();
		f.setVisible(true);
	}
	
	public void initialize() {
		n = 5;
		
		f = new JFrame("Display");
		
		lbl1 = new JLabel("Completion Times - ");
		lbl2 = new JLabel("Turn-Around Times - ");
		lbl3 = new JLabel("Waiting Times - ");
		lbl4 = new JLabel("Gantt Chart - ");
		
		tf1 = new JTextField[n];
		tf2 = new JTextField[n];
		tf3 = new JTextField[n];
		for(i=0;i<n;i++) {
			tf1[i] = new JTextField(5);
			tf1[i].setText(Integer.toString(ct[i]));
			tf1[i].setEditable(false);
			tf2[i] = new JTextField(5);
			tf2[i].setText(Integer.toString(tt[i]));
			tf2[i].setEditable(false);
			tf3[i] = new JTextField(5);
			tf3[i].setText(Integer.toString(wt[i]));
			tf3[i].setEditable(false);
		}
		tf4 = new JTextField[time];
		for(i=0;i<time;i++) {
			tf4[i] = new JTextField(5);
			tf4[i].setText("P"+(gc[i]+1));
			tf4[i].setEditable(false);
		}
		
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
		for(i=0;i<n;i++)	pnl3.add(tf3[i]);
		pnl4.add(lbl4);
		for(i=0;i<time;i++)	pnl4.add(tf4[i]);
		
		f.add(pnl4);
		f.add(pnl1);
		f.add(pnl2);
		f.add(pnl3);
		
		pnl1.setLayout(new FlowLayout());
		pnl2.setLayout(new FlowLayout());
		pnl3.setLayout(new FlowLayout());
		pnl4.setLayout(new FlowLayout());
		
		f.setLayout(new GridLayout(4,1));
	}
	
	public void register() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
}
