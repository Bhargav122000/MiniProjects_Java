import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestDialog {
	private JFrame f;
	private JButton btnf;
	private JTextField tf;
	private JDialog d;
	private JList<String> l;
	private JButton btnd;
	
	private String []team;
	
	public TestDialog() {
		initializeComponents();
		addComponents();
		addListeners();
		
		f.pack();
		f.setVisible(true);
	}
	
	public void initializeComponents() {
		team = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		
		f = new JFrame("Testing Dialog");
		
		btnf = new JButton("Click to get Dialog");
		btnd = new JButton("submit");
		
		tf = new JTextField("---");
		
		d = new JDialog(f,"Player");
		
		l = new JList<String>(team);
	}
	
	public void addComponents() {
		tf.setEditable(false);
		
		f.add(btnf);
		f.add(tf);
		
		d.add(l);
		d.add(btnd);
		
		f.setLayout(new FlowLayout());
		d.setLayout(new GridLayout(2,1,10,0));
	}
	
	public void addListeners() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btnf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setVisible(true);
			}
		});
		
		btnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = l.getSelectedIndex();
				tf.setText("player "+team[i]+" is selected");
				d.setVisible(false);
			}
		});
	}
	
	public static void main(String [] args) {
		new TestDialog();
	}
}
