import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display {
	private JFrame f;
	private JPanel pnl1,pnl2,pnl3;
	private JButton btn;
	private JLabel lbl;
	
	public Display() {
		getFrame();
		displayFrame();
	}
	
	public void getFrame() {
		f = new JFrame("Results");
		
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		pnl3 = new JPanel();
		
		btn = new JButton("show");
		
		lbl = new JLabel("Click on 'show' to see the waiting times comparision-");
		
		pnl1.add(FCFS.pnl);
		pnl1.add(SJF_P.pnl);
		pnl1.add(SJF_NP.pnl);
		pnl2.add(PJF_P.pnl);
		pnl2.add(PJF_NP.pnl);
		pnl2.add(RRS.pnl);
		pnl3.add(lbl);
		pnl3.add(btn);
		
		f.add(pnl1);
		f.add(pnl2);
		f.add(pnl3);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WaitingTimes();
			}
		});
	}
	
	public void displayFrame() {
		pnl1.setLayout(new GridLayout(1,3));
		pnl2.setLayout(new GridLayout(1,3));
		pnl3.setLayout(new FlowLayout());
		
		f.setLayout(new GridLayout(3,2,20,20));
		
		f.pack();
		f.setVisible(true);
	}
}
