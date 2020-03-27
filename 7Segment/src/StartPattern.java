import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartPattern {

	private JFrame f;
	private JTextArea ta;
	private JButton btn_start;
	
	public StartPattern() {
		initialise();
		add();
		register();
	
		f.pack();
		f.setVisible(true);
	}
	
	public void initialise() {
		f = new JFrame("Start Pattern");
		ta = new JTextArea("Choose the correct option for all the questions to get correct pattern!!");
		ta.setEditable(false);
		btn_start = new JButton("Start the test");
	}
	
	public void add() {
		f.add(ta);
		f.add(btn_start);
		
		f.setLayout(new FlowLayout());
	}
	
	public void register() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Pattern();
				f.setVisible(false);
			}
		});
	}
	
	public static void main(String []args) {
		new StartPattern();
	}
}
