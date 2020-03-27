import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pattern {
	private JFrame f;
	private JPanel pnl[];
	private JLabel lbl[];
	private JTextField tf[];
	private JRadioButton rb1[],rb2[];
	private ButtonGroup bg[];
	private JButton btn_submit;
	
	private String q_list[],q_test[];
	private int a_list[],a_test[];
	private int a_obt[];
	private long start_time,end_time;
	
	public Pattern() {
		prepareQA();
		initialise();
		add();
		register();
		
		f.pack();
		f.setVisible(true);
		start_time = System.currentTimeMillis();
	}
	
	public void prepareQA() {
		int i,j;
		int num1,num2,num3,op1,op2,result;
		double result_value = 0.0;
		String opv1=" ",opv2=" ";
		
		Random r = new Random();
		
		q_list = new String[21];
		q_test = new String[7];
		
		a_list = new int[21];
		a_test = new int[7];
		
		a_obt = new int[7];
		for(i=0;i<7;i++)	a_obt[i] = 0;
		
		for(i=0;i<21;i++) {
			num1 = r.nextInt(30)+21;
			num2 = r.nextInt(20)+21;
			num3 = r.nextInt(10)+11;
			op1 = r.nextInt(3);
			op2 = r.nextInt(4);
			result = r.nextInt(2);
			
			if(op1 == 0) {
				opv1 = "+";
				if(op2 == 0){
					result_value = (double)(num1+num2)+num3;
					opv2 = "+";
				}
				if(op2 == 1){
					result_value = (double)(num1+num2)-num3;
					opv2 = "-";
				}
				if(op2 == 2) {
					result_value = (double)(num1+num2)*num3;
					opv2 = "*";
				}
				if(op2 == 3) {
					result_value = (double)(num1+num2)/num3;
					opv2 = "/";
				}
			}
			else if(op1 == 1) {
				opv1 = "-";
				if(op2 == 0){
					result_value = (double)(num1-num2)+num3;
					opv2 = "+";
				}
				if(op2 == 1){
					result_value = (double)(num1-num2)-num3;
					opv2 = "-";
				}
				if(op2 == 2) {
					result_value = (double)(num1-num2)*num3;
					opv2 = "*";
				}
				if(op2 == 3) {
					result_value = (double)(num1-num2)/num3;
					opv2 = "/";
				}			
			}
			else if(op1 == 2) {
				opv1 = "*";
				if(op2 == 0){
					result_value = (double)(num1*num2)+num3;
					opv2 = "+";
				}
				if(op2 == 1){
					result_value = (double)(num1*num2)-num3;
					opv2 = "-";
				}
				if(op2 == 2) {
					result_value = (double)(num1*num2)*num3;
					opv2 = "*";
				}
				if(op2 == 3) {
					result_value = (double)(num1*num2)/num3;
					opv2 = "/";
				}
			}
			
			if(result == 0) {
				j = 0;
				while(j == 0)	j = r.nextInt(20);
				if(r.nextInt(2)%2 == 0)	result_value = result_value + j;
				else					result_value = result_value - j;
				a_list[i] = 0;
			}else {
				a_list[i] = 1;
			}
			
			String t = String.format("%.02f",result_value);
			
			q_list[i] = "("+Integer.toString(num1)+opv1+Integer.toString(num2)+")"+opv2+Integer.toString(num3)+"="+t;
		}
		
		for(i=0;i<7;i++) {
			j = (i*3) + r.nextInt(3);
			q_test[i] = q_list[j];
			a_test[i] = a_list[j];
		}
	}
	
	public void initialise() {
		int i;
		
		f = new JFrame("Pattern");
		
		pnl = new JPanel[8];
		for(i=0;i<8;i++)	pnl[i] = new JPanel();
		
		lbl = new JLabel[7];
		for(i=0;i<7;i++)	lbl[i] = new JLabel("Question-"+(i+1));
		
		tf = new JTextField[7];
		for(i=0;i<7;i++)	{
			tf[i] = new JTextField(q_test[i],12);
			tf[i].setEditable(false);
		}
		
		rb1 = new JRadioButton[7];
		rb2 = new JRadioButton[7];
		for(i=0;i<7;i++) {
			rb1[i] = new JRadioButton("True");
			rb2[i] = new JRadioButton("False");
		}
		
		bg = new ButtonGroup[7];
		for(i=0;i<7;i++)	bg[i] = new ButtonGroup();
		
		btn_submit = new JButton("Check for pattern");
	}
	
	public void add() {
		int i;
		
		for(i=0;i<7;i++) {
			bg[i].add(rb1[i]);
			bg[i].add(rb2[i]);
		}
		
		for(i=0;i<7;i++) {
			pnl[i].add(lbl[i]);
			pnl[i].add(tf[i]);
			pnl[i].add(rb1[i]);
			pnl[i].add(rb2[i]);
		}
		
		pnl[7].add(btn_submit);
		
		for(i=0;i<8;i++)	f.add(pnl[i]);
		
		for(i=0;i<8;i++)	pnl[i].setLayout(new FlowLayout());
		f.setLayout(new GridLayout(8,1));
	}
	
	public void register() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				end_time =System.currentTimeMillis();
				GetResult obj = new GetResult();
				int i;
				
				for(i=0;i<7;i++) {
					if(rb1[i].isSelected() == true)		a_obt[i] = 1;
					if(rb2[i].isSelected() == true)		a_obt[i] = 0;
				}
				
				obj.getOP(a_test,a_obt,(end_time-start_time));
				f.setVisible(false);
				obj.setSize(400,400);
				obj.setVisible(true);
			}
		});
	}
}
