import javax.swing.*;
import java.awt.*;

public class FCFS {

	private int n;
	private int []at;
	private int []bt;
	private int []ct;
	private int []tt;
	private int []wt;
	private int []dbt;
	private int []gc;
	private int []rq;
	private int i,j,k,temp,gc_length;
	static double avg_wt = 0;

	static JPanel pnl,pnl1,pnl2,pnl3,pnl4,pnl5;
	static JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
	static JTextField tf2[],tf3[],tf4[],tf5;
	
	public FCFS(int a[],int b[]) {
		n = 6;
		
		at = a;
		bt = b;
		ct = new int[n];
		tt = new int[n];
		wt = new int[n];
		dbt = new int[n];
		rq = new int[2*n];
		
		for(i=0,gc_length=0;i<n;i++) {
			ct[i]=-1;
			tt[i]=-1;
			wt[i]=-1;
			//rq[i]=-1;
			dbt[i]=bt[i];
			gc_length+=bt[i];
		}
		for(i=0;i<2*n;i++)	rq[i]=-1;
		
		gc_length = gc_length*2;
		gc = new int[gc_length];
		for(i=0;i<gc_length;i++)	gc[i]=-1;
		
		scheduling();
		getPanel();
	}
	
	public void scheduling() {
		int tsum=0;
		int time=0;
		
		while(true) {
			tsum = 0;
			for(i=0;i<n;i++)	tsum+=dbt[i];
			
			if(tsum == 0)	break;
			
			for(i=0;i<n;i++)	rq[i]=-1;
			for(i=0,j=0;i<n;i++) {
				if(at[i]<=time && dbt[i]>0)	rq[j++]=i;
			}
			
			for(i=0;i<j-1;i++) {
				for(k=0;k<j-1-i;k++) {
					if(at[rq[k]]>at[rq[k+1]]) {
						temp=rq[k];
						rq[k]=rq[k+1];
						rq[k+1]=temp;
					}
				}
			}
			
			if(rq[0]==-1) {
				time++;
			}
			else {
				i=0;
				while(rq[i]!=-1) {
					j = rq[i];
					while(dbt[j] != 0) {
						gc[time]=j;
						time=time+1;
						dbt[j]=dbt[j]-1;
					}
					
					if(dbt[j]==0) {
						ct[j]=time;
					}
					i++;
				}
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
		
		lbl1 = new JLabel("First Come First Serve - Algo");
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
