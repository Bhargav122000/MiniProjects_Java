import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RRS{
	private int n;
	private int []at;
	private int []bt;
	private int []ct;
	private int []tt;
	private int []wt;
	private int []dbt;
	private int []gc;
	private int []rq;
	private int Quantum;
	private int i,j,k,temp,gc_length;
	static double avg_wt = 0;
	
	static JPanel pnl,pnl1,pnl2,pnl3,pnl4,pnl5;
	static JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
	static JTextField tf2[],tf3[],tf4[],tf5;
	
	public RRS(int []a,int []b,int quantum) {
		n = 6;
		
		at = a;
		bt = b;
		ct = new int[n];
		tt = new int[n];
		wt = new int[n];
		dbt = new int[n];
		rq = new int[n];
			
		Quantum = quantum;
		
		for(i=0,gc_length=0;i<n;i++) {
			ct[i]=-1;
			tt[i]=-1;
			wt[i]=-1;
			rq[i]=-1;
			dbt[i]=bt[i];
			gc_length+=bt[i];
		}
		
		gc_length = gc_length*2;
		gc = new int[gc_length];
		for(i=0;i<gc_length;i++)	gc[i]=-1;
		
		scheduling();
		getPanel();
		
	}

	public boolean present(int j) {
		int i=0;
		for(i=0;i<n;i++) {
			if(rq[i] == j)	return true;
		}
		return false;
	}
	
	public void sort_rq(int start,int stop) {
		int i;
		
		for(i=start;i<stop;i++) {
			for(j=start;j<stop-i;j++) {
				if(at[rq[j]] > at[rq[j+1]]) {
					temp = rq[j];
					rq[j] = rq[j+1];
					rq[j+1] = temp;
				}
			}
		}		
	}
	
	public void scheduling() {
		int time = 0;
		int tsum = 0;
		int done,rq_count = 0,iter;
		int start,stop;
		while(true) {
			tsum = 0;
			for(i=0;i<n;i++)	tsum += dbt[i];
			
			if(tsum == 0)	break;
			
			if(rq[0] == -1) {
				if(time==0) {
					for(i=0,j=0;i<n;i++) {
						if(at[i] == 0 && dbt[i]>0)	rq[j++] = i;
					}
					rq_count = j;	
				}
			}
			else if(rq[0]!=-1) {
				done = rq[0];
				for(i=0;i<rq_count-1;i++)	rq[i]=rq[i+1];
				
				rq[i] = -1;
				
				start = i;
				for(j=0;j<n;j++) {
					if(!present(j) && j != done) {
						if(at[j]<=time && dbt[j]>0)		rq[i++] = j;
					}
				}
				
				stop = i-1;
				sort_rq(start,stop);
				
				if(dbt[done]>0) 	rq[i++] = done;
				rq_count = i;
			}
			
			if(rq[0]==-1) {
				time++;
				continue;
			}
			
			k = rq[0];
			iter = 0;
			if(dbt[k] > Quantum) {
				while(iter != Quantum) {
					dbt[k]--;
					gc[time++] = k;
					iter++;
				}
			}
			else {
				if(dbt[k] < Quantum) {
					while(dbt[k] > 0) {
						dbt[k]--;
						gc[time++] = k;
					}
				}
				else {
					while(iter < Quantum) {
						dbt[k]--;
						gc[time++] = k;
						iter++;
					}
				}
				ct[k] = time;
			}
		}
		
		for(i=0;i<n;i++) {
			tt[i]=ct[i]-at[i];
			wt[i]=tt[i]-bt[i];
		}	
	}
	
	public void getPanel() {
		int i;
		
		pnl = new JPanel();
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		pnl3 = new JPanel();
		pnl4 = new JPanel();
		pnl5 = new JPanel();
		
		lbl1 = new JLabel("Round Robin Scheduling - Algo");
		lbl2 = new JLabel("Completion Times");
		lbl3 = new JLabel("TurnAround Times");
		lbl4 = new JLabel("Waiting Times");
		lbl5 = new JLabel("Average Waiting Time");
		
		tf2 = new JTextField[n];
		for(i=0;i<n;i++)	tf2[i] = new JTextField(Integer.toString(ct[i]));
		tf3 = new JTextField[n];
		for(i=0;i<n;i++)	tf3[i] = new JTextField(Integer.toString(tt[i]));
		tf4 = new JTextField[n];
		for(i=0;i<n;i++)	tf4[i] = new JTextField(Integer.toString(wt[i]));
		
		for(i=0;i<n;i++)	avg_wt += (double)wt[i];
		avg_wt = avg_wt/(double)n;
		tf5 = new JTextField(String.format("%.02f",avg_wt));
		
		pnl1.add(lbl1);
		pnl2.add(lbl2);
		for(i=0;i<n;i++)	pnl2.add(tf2[i]);
		pnl3.add(lbl3);
		for(i=0;i<n;i++)	pnl3.add(tf3[i]);
		pnl4.add(lbl4);
		for(i=0;i<n;i++)	pnl4.add(tf4[i]);
		pnl5.add(lbl5);
		pnl5.add(tf5);
		
		pnl.add(pnl1);
		pnl.add(pnl2);
		pnl.add(pnl3);
		pnl.add(pnl4);
		pnl.add(pnl5);
		
		pnl.setLayout(new GridLayout(5,1));

	}
}