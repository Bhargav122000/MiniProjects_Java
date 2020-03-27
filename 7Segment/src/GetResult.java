import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class GetResult extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JLabel lbl1,lbl2,lbl3,lbl4;
	private JTextField tf1,tf2,tf3,tf4;
	Graphics g;
	private int actual[],obtained[];
	private long duration;
	
	public GetResult() {
		
		super();
		
		lbl1 = new JLabel("Result status-");
		lbl2 = new JLabel("Actual pattern color-");
		lbl3 = new JLabel("Obtained pattern color-");
		lbl4 = new JLabel("Duration(sec)-");
		
		tf1 = new JTextField(20);
		tf2 = new JTextField(2);tf2.setBackground(Color.ORANGE);
		tf3 = new JTextField(2);tf3.setBackground(Color.GREEN);
		tf4 = new JTextField(5);
		
		tf1.setEditable(false);
		tf2.setEditable(false);
		tf3.setEditable(false);
		tf4.setEditable(false);
		
		this.add(lbl1);
		this.add(tf1);
		this.add(lbl2);
		this.add(tf2);
		this.add(lbl3);
		this.add(tf3);
		this.add(lbl4);
		this.add(tf4);
		
		this.setLayout(new FlowLayout());
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void getOP(int []actual,int []obtained,long period) {
		this.actual = actual;
		this.obtained = obtained;
		this.duration = TimeUnit.MILLISECONDS.toSeconds(period);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		int i;
		int gap = 80;
		
		for(i=0;i<7;i++) {
			if(actual[i] != obtained[i]) {
				tf1.setText("You got the wrong pattern");
				break;
			}
		}
		
		if(i == 7)	tf1.setText("You got the correct pattern");
		tf4.setText(duration+"");
		
		g.setColor(Color.ORANGE);
		
		if(actual[0] == 1)	g.fillRect(30,120,34,2);
		if(actual[1] == 1)	g.fillRect(62,120,2,30);
		if(actual[2] == 1)	g.fillRect(62,152,2,30);
		if(actual[3] == 1)	g.fillRect(30,180,34,2);
		if(actual[4] == 1)	g.fillRect(30,152,2,30);
		if(actual[5] == 1)	g.fillRect(30,120,2,30);
		if(actual[6] == 1)	g.fillRect(30,150,34,2);
		
		g.setColor(Color.GREEN);
		
		if(obtained[0] == 1)	g.fillRect(30+gap,120,34,2);
		if(obtained[1] == 1)	g.fillRect(62+gap,120,2,30);
		if(obtained[2] == 1)	g.fillRect(62+gap,152,2,30);
		if(obtained[3] == 1)	g.fillRect(30+gap,180,34,2);
		if(obtained[4] == 1)	g.fillRect(30+gap,152,2,30);
		if(obtained[5] == 1)	g.fillRect(30+gap,120,2,30);
		if(obtained[6] == 1)	g.fillRect(30+gap,150,34,2);
	}
}
