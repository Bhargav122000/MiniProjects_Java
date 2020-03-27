import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Team {
	private JFrame f;
	private JPanel p;
	private JList<String> team;
	private JButton btn;
	private JRadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8;
	private ButtonGroup bg;
	
	private String [] ind,aus,eng,nz;
	private String [] sa,pak,sl,ban;
	
	public Team() {
		initializeComponents();
		addComponents();
		addListeners();
		
		f.setLayout(new FlowLayout());
		f.pack();
		f.setVisible(true);
	}
	
	public void initializeComponents() {
		f = new JFrame("Team ");
		p = new JPanel();
		btn = new JButton("Submit");
		
		bg = new ButtonGroup();
		rb1 = new JRadioButton("India");
		rb2 = new JRadioButton("Australia");
		rb3 = new JRadioButton("England");
		rb4 = new JRadioButton("NewZeaLand");
		rb5 = new JRadioButton("SouthAfrica");
		rb6 = new JRadioButton("Pakistan");
		rb7 = new JRadioButton("SriLanka");
		rb8 = new JRadioButton("Bangladesh");
		
		ind = new String[] {"rohit","rahul","kohli","shreyas","manish","rishabh","jadeja","kuldeep","bhuvi","shami","bumrah"};
		aus = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		eng = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		nz = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		sa = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		pak = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		sl = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		ban = new String[] {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11"};
		
	}
	
	public void addComponents() {
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);
		bg.add(rb5);
		bg.add(rb6);
		bg.add(rb7);
		bg.add(rb8);
		
		p.add(rb1);
		p.add(rb2);
		p.add(rb3);
		p.add(rb4);
		p.add(rb5);
		p.add(rb6);
		p.add(rb7);
		p.add(rb8);
		
		p.add(btn);
		
		f.add(p);
	}
	
	public void addListeners() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rb1.isSelected()) team = new JList<String>(ind);
				if(rb2.isSelected()) team = new JList<String>(aus);
				if(rb3.isSelected()) team = new JList<String>(eng);
				if(rb4.isSelected()) team = new JList<String>(nz);
				if(rb5.isSelected()) team = new JList<String>(sa);
				if(rb6.isSelected()) team = new JList<String>(pak);
				if(rb7.isSelected()) team = new JList<String>(sl);
				if(rb8.isSelected()) team = new JList<String>(ban);
				
				p.add(team);
			}
		});
	}
	
	public static void main(String [] args) {
		new Team();
	}
}
