import java.awt.*;
import java.awt.event.*;

public class Demo {
	private Frame f;
	private Panel pnl1[];
	private Label lbl1;
	private TextField tf1[];
	private Button btn11;
	
	int n;
	int pages[];
	int i,j,k;
	int fifo_frame[][],lru_frame[][],optimal_frame[][];
	FIFO obj1;
	LRU obj2;
	Optimal obj3;
	
	private Frame f_;
	private Panel pnl2[],pnl3[],pnl4[];
	private Label lbl2[],lbl3[],lbl4[];
	private TextField tf2[][],tf3[][],tf4[][],tf21,tf31,tf41;
	private Button btn12;
	
	public Demo() {
		initialise();
		add();
		register();
		
		f.pack();
		f.setVisible(true);
	}
	
	public void initialise() {
		n = 15;
		f = new Frame("Page Scheduling");
		
		pnl1 = new Panel[3];
		for(i=0;i<3;i++) {
			pnl1[i] = new Panel();
			pnl1[i].setBackground(Color.GRAY);
		}
		
		lbl1 = new Label("Page References");
		
		tf1 = new TextField[n];
		for(i=0;i<n;i++) {
			tf1[i] = new TextField(3);
			tf1[i].setBackground(Color.LIGHT_GRAY);
		}
		
		btn11 = new Button("Get PageFaults");
	}
	
	public void add() {
		pnl1[0].add(lbl1);
		for(i=0;i<n;i++)	pnl1[0].add(tf1[i]);
		pnl1[1].add(btn11);
		
		pnl1[2].add(pnl1[0]);
		pnl1[2].add(pnl1[1]);
		f.add(pnl1[2]);
		
		pnl1[2].setLayout(new GridLayout(2,1));
	}
	
	public void register() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pages = new int[n];
				for(i=0;i<n;i++)	pages[i] = Integer.parseInt(tf1[i].getText());
				
				obj1 = new FIFO(pages);
				obj2 = new LRU(pages);
				obj3 = new Optimal(pages);
				
				fifo_frame = obj1.fifo();
				lru_frame = obj2.lru();
				optimal_frame = obj3.optimal();
				
				rearrange();
			}
		});
	}
	
	public void rearrange() {
		f.setVisible(false);
		
		f_ = new Frame("Page Scheduling");
		f_.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		pnl2 = new Panel[3];
		pnl3 = new Panel[3];
		pnl4 = new Panel[3];
		for(i=0;i<3;i++) {
			pnl2[i] = new Panel();pnl2[i].setBackground(Color.GRAY);
			pnl3[i] = new Panel();pnl3[i].setBackground(Color.GRAY);
			pnl4[i] = new Panel();pnl4[i].setBackground(Color.GRAY);
		}
		
		lbl2 = new Label[2];
		lbl2[0] = new Label("FIFO page scheduling");
		lbl2[1] = new Label("#PageFaults");
		lbl3 = new Label[2];
		lbl3[0] = new Label("LRU page scheduling");
		lbl3[1] = new Label("#PageFaults");
		lbl4 = new Label[2];
		lbl4[0] = new Label("Optimal page scheduling");
		lbl4[1] = new Label("#PageFaults");
		
		tf2 = new TextField[n][3];
		for(i=0;i<n;i++) {
			for(j=0;j<3;j++) {
				tf2[i][j] = new TextField(3);
				tf2[i][j].setBackground(Color.YELLOW);
				tf2[i][j].setEditable(false);
				if(fifo_frame[i][j] == -1)	tf2[i][j].setText(String.format("%3s","-"));
				else	tf2[i][j].setText(String.format("%3d",fifo_frame[i][j]));
			}
		}
		tf3 = new TextField[n][3];
		for(i=0;i<n;i++) {
			for(j=0;j<3;j++) {
				tf3[i][j] = new TextField(3);
				tf3[i][j].setBackground(Color.YELLOW);
				tf3[i][j].setEditable(false);
				if(lru_frame[i][j] == -1)	tf3[i][j].setText(String.format("%3s","-"));
				else	tf3[i][j].setText(String.format("%3d",lru_frame[i][j]));
			}
		}
		tf4 = new TextField[n][3];
		for(i=0;i<n;i++) {
			for(j=0;j<3;j++) {
				tf4[i][j] = new TextField(3);
				tf4[i][j].setBackground(Color.YELLOW);
				tf4[i][j].setEditable(false);
				if(optimal_frame[i][j] == -1)	tf4[i][j].setText(String.format("%3s","-"));
				else	tf4[i][j].setText(String.format("%3d",optimal_frame[i][j]));
			}
		}
		tf21 = new TextField(Integer.toString(obj1.getPageFaults()));
		tf21.setBackground(Color.LIGHT_GRAY);tf21.setEditable(false);
		tf31 = new TextField(Integer.toString(obj2.getPageFaults()));
		tf31.setBackground(Color.LIGHT_GRAY);tf31.setEditable(false);
		tf41 = new TextField(Integer.toString(obj3.getPageFaults()));
		tf41.setBackground(Color.LIGHT_GRAY);tf41.setEditable(false);
		
		btn12 = new Button("Close");
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		pnl2[0].add(lbl2[0]);
		pnl2[0].add(lbl2[1]);
		pnl2[0].add(tf21);
		for(i=0;i<3;i++) {
			for(j=0;j<n;j++)	pnl2[1].add(tf2[j][i]);
		}
		pnl2[2].add(pnl2[0]);
		pnl2[2].add(pnl2[1]);
		
		pnl3[0].add(lbl3[0]);
		pnl3[0].add(lbl3[1]);
		pnl3[0].add(tf31);
		for(i=0;i<3;i++) {
			for(j=0;j<n;j++)	pnl3[1].add(tf3[j][i]);
		}
		pnl3[2].add(pnl3[0]);
		pnl3[2].add(pnl3[1]);
		
		pnl4[0].add(lbl4[0]);
		pnl4[0].add(lbl4[1]);
		pnl4[0].add(tf41);
		for(i=0;i<3;i++) {
			for(j=0;j<n;j++)	pnl4[1].add(tf4[j][i]);
		}
		pnl4[2].add(pnl4[0]);
		pnl4[2].add(pnl4[1]);
		
		pnl1[1].add(btn12);
		
		f_.add(pnl1[2]);
		f_.add(pnl2[2]);
		f_.add(pnl3[2]);
		f_.add(pnl4[2]);
		
		pnl2[1].setLayout(new GridLayout(3,n,10,10));
		pnl2[2].setLayout(new GridLayout(2,1));
		pnl3[1].setLayout(new GridLayout(3,n,10,10));
		pnl3[2].setLayout(new GridLayout(2,1));
		pnl4[1].setLayout(new GridLayout(3,n,10,10));
		pnl4[2].setLayout(new GridLayout(2,1));
		
		f_.setLayout(new GridLayout(4,1,5,5));
		
		f_.pack();
		f_.setVisible(true);
	}
	
	public static void main(String []args) {
		new Demo();
	}
}
