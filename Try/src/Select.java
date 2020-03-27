import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Select {
	private JFrame f;
	private JPanel p;
	private JList<String> l;
	private JButton btn;
	
	private String [] s = {"Rohit","Rahul","Virat","Shreyas","Manish","Jadeja","Rishabh","Bhuvi","Kuldeep","Shami","Bumrah","Dhawan","Navdeep","Chahal"};
	
	public Select() {
		initializeComponents();
		addComponents();
		addListeners();
		
		f.setLayout(new FlowLayout());
		f.pack();
		f.setVisible(true);
	}
	
	public void initializeComponents() {
		f = new JFrame("Selection List");
		p = new JPanel();
		l = new JList<String>(s);
		btn = new JButton("Submit");
		
		l.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}
	
	public void addComponents() {
		p.add(l);
		f.add(p);
		f.add(btn);
	}
	
	public void addListeners() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a[] = l.getSelectedIndices();
				System.out.println("Playing XI -");
				for(int i = 0;i < 11;i++)
					System.out.println(s[a[i]]);
			}
		});
	}
	
	public static void main(String [] args) {
		new Select();
	}
}