import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;

class DrawRectangle extends JFrame
{

	private static final long serialVersionUID = 1L;
	
	JButton btn;
	JTextField tf;
	Graphics g;
	String s1,s;
	static int gap = 50;

	public DrawRectangle()
	{
		super();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tf = new JTextField(10);
		add(tf);
		btn = new JButton("submit");
		add(btn);
		setLayout(new FlowLayout());
		register();
		setSize(500,500);
		setVisible(true);
	}


	public void paint(Graphics g)
	{
		super.paint(g);
  
		g.setColor(Color.RED);
 
		s1 = tf.getText();
		s = s1.toUpperCase();
		if(s.length()>0)	display(s,g);
		
	}

	public void display(String s,Graphics g) {
		int length = s.length();
		int i = 0;
	
		for(i=0;i<length;i++) {
			a_line(s.charAt(i),i,g);
			b_line(s.charAt(i),i,g);
			c_line(s.charAt(i),i,g);
			d_line(s.charAt(i),i,g);
			e_line(s.charAt(i),i,g);
			f_line(s.charAt(i),i,g);
			g_line(s.charAt(i),i,g);
		
			x1_line(s.charAt(i),i,g);
			x2_line(s.charAt(i),i,g);
			x3_line(s.charAt(i),i,g);
			x4_line(s.charAt(i),i,g);
		
			ku_line(s.charAt(i),i,g);
			kl_line(s.charAt(i),i,g);
		
			v1_line(s.charAt(i),i,g);
			v2_line(s.charAt(i),i,g);
		
			vm_line(s.charAt(i),i,g);
		
			j_line(s.charAt(i),i,g);
		}
	}

	public void a_line(char c,int n,Graphics g) {
		if(c=='A'||c=='C'||c=='E'||c=='F'||c=='G'||c=='I'||c=='J')	g.fillRect(30+(n*gap),80,34,2);//a
		
		if(c=='P'||c=='Q'||c=='R'||c=='S'||c=='T'||c=='Z')	g.fillRect(30+(n*gap),80,34,2);//a
		
		if(c=='0'||c=='2'||c=='3'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9')	g.fillRect(30+(n*gap),80,34,2);//a
	}

	public void b_line(char c,int n,Graphics g) {
		if(c=='A'||c=='D'||c=='H'||c=='M'||c=='N'||c=='P')	g.fillRect(62+(n*gap),80,2,30);//b
		
		if(c=='Q'||c=='R'||c=='U'||c=='W'||c=='Y')	g.fillRect(62+(n*gap),80,2,30);//b
	
		if(c=='0'||c=='2'||c=='3'||c=='4'||c=='7'||c=='8'||c=='9')	g.fillRect(62+(n*gap),80,2,30);//b
	}

	public void c_line(char c,int n,Graphics g) {
		if(c=='A'||c=='B'||c=='D'||c=='G'||c=='H'||c=='M'||c=='N')	g.fillRect(62+(n*gap),112,2,30);//c
		
		if(c=='O'||c=='Q'||c=='S'||c=='U'||c=='W'||c=='Y')	g.fillRect(62+(n*gap),112,2,30);//c
		
		if(c=='0'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9')	g.fillRect(62+(n*gap),112,2,30);//c
	}

	public void d_line(char c,int n,Graphics g) {
		if(c=='B'||c=='C'||c=='D'||c=='E'||c=='G'||c=='I'||c=='L')	g.fillRect(30+(n*gap),140,34,2);//d
		
		if(c=='O'||c=='Q'||c=='S'||c=='U'||c=='Y'||c=='Z')	g.fillRect(30+(n*gap),140,34,2);//d
		
		if(c=='0'||c=='2'||c=='3'||c=='5'||c=='6'||c=='8')	g.fillRect(30+(n*gap),140,34,2);//d
	}

	public void e_line(char c,int n,Graphics g) {
		if(c=='A'||c=='B'||c=='C'||c=='D'||c=='E'||c=='F'||c=='G'||c=='H'||c=='K')	g.fillRect(30+(n*gap),112,2,30);//e
		
		if(c=='L'||c=='M'||c=='N'||c=='O'||c=='P'||c=='Q'||c=='R'||c=='U'||c=='W')	g.fillRect(30+(n*gap),112,2,30);//e
		
		if(c=='0'||c=='2'||c=='6'||c=='8')	g.fillRect(30+(n*gap),112,2,30);//e
	}

	public void f_line(char c,int n,Graphics g) {
		if(c=='A'||c=='B'||c=='C'||c=='E'||c=='F'||c=='G'||c=='H'||c=='K'||c=='L')	g.fillRect(30+(n*gap),80,2,30);//f
	
		if(c=='M'||c=='N'||c=='P'||c=='Q'||c=='R'||c=='S'||c=='U'||c=='W'||c=='Y')	g.fillRect(30+(n*gap),80,2,30);//f
	
		if(c=='0'||c=='4'||c=='5'||c=='6'||c=='8'||c=='9')	g.fillRect(30+(n*gap),80,2,30);//f
	}

	public void g_line(char c,int n,Graphics g) {
		if(c=='A'||c=='B'||c=='D'||c=='E'||c=='F'||c=='H'||c=='O'||c=='P'||c=='R'||c=='S'||c=='Y')	g.fillRect(30+(n*gap),110,34,2);//g
	
		if(c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='8'||c=='9')	g.fillRect(30+(n*gap),110,34,2);//g
	}

	public void x1_line(char c,int n,Graphics g) {
		if(c=='M'||c=='N'||c=='X')	g.drawLine(30+(n*gap),80,47+(n*gap),112);// \ upper line
	}

	public void x2_line(char c,int n,Graphics g) {
		if(c=='M'||c=='X'||c=='Z')	g.drawLine(62+(n*gap),80,47+(n*gap),112);// / upper line
	}

	public void x3_line(char c,int n,Graphics g) {
		if(c=='N'||c=='Q'||c=='R'||c=='W'||c=='X')	g.drawLine(62+(n*gap),141,47+(n*gap),112);// \ lower line
	}

	public void x4_line(char c,int n,Graphics g) {
		if(c=='W'||c=='X'||c=='Z')	g.drawLine(30+(n*gap),141,47+(n*gap),112);// / lower line
	}

	public void ku_line(char c,int n,Graphics g) {
		if(c=='K')	g.drawLine(30+(n*gap),112,62+(n*gap),80);// k upper line
	}

	public void kl_line(char c,int n,Graphics g) {
		if(c=='K')g.drawLine(30+(n*gap),112,62+(n*gap),141);// k lower line
	}

	public void v1_line(char c,int n,Graphics g) {
		if(c=='V')	g.drawLine(30+(n*gap),80,47+(n*gap),140);// v \ line
	}

	public void v2_line(char c,int n,Graphics g) {
		if(c=='V')	g.drawLine(62+(n*gap),80,47+(n*gap),140);// v / line
	}

	public void vm_line(char c,int n,Graphics g) {
		if(c=='I'||c=='J'||c=='T'||c=='1')	g.drawLine(47+(n*gap),80,47+(n*gap),140);// vertical middle line
	}

	public void j_line(char c,int n,Graphics g) {
		if(c=='J')g.drawLine(47+(n*gap),140,30+(n*gap),112);// J line
	}

	public void register() {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
	}

	public static void main(String[]args){
		new DrawRectangle();
	}
}