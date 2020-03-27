import java.util.*;

public class Model_p{
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
	
	Scanner ip= new Scanner(System.in);
	
	public Model_p() {
		System.out.print("Enter # processes:");
		n = ip.nextInt();
		
		at = new int[n];
		bt = new int[n];
		ct = new int[n];
		tt = new int[n];
		wt = new int[n];
		dbt = new int[n];
		rq = new int[n];
		
		System.out.print("Enter Arrival Times:");
		for(i=0;i<n;i++)	at[i]=ip.nextInt();
		
		System.out.print("Enter Burst Times:");
		for(i=0;i<n;i++)	bt[i]=ip.nextInt();
		
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
		
		System.out.println("SJF(P)->");
		System.out.println();
		scheduling();
		
	}

	public void scheduling() {
		int time = 0;
		int tsum = 0;
		
		while(true) {
			tsum = 0;
			for(i=0;i<n;i++)	tsum += dbt[i];
			
			if(tsum == 0)	break;
			
			for(i=0;i<n;i++)	rq[i]=-1;
			for(i=0,j=0;i<n;i++) {
				if(at[i]<=time && dbt[i]>0)		rq[j++] = i;
			}
			
			if(rq[0]==-1) {
				time++;
				continue;
			}
			
			for(i=0;i<j-1;i++) {
				for(k=0;k<j-1-i;k++) {
					if(dbt[rq[k]]>dbt[rq[k+1]]) {
						temp = rq[k];
						rq[k] = rq[k+1];
						rq[k+1] = temp;
					}
				}
			}
			
			i = 0;
			
			if(dbt[rq[i]] == 1) {
				dbt[rq[i]]--;
				gc[time] = rq[i];
				time += 1;
				ct[rq[i]] = time;
			}
			else {
				dbt[rq[i]]--;
				gc[time++] = rq[i];
			}
			
		}
		
		for(i=0;i<n;i++) {
			tt[i]=ct[i]-at[i];
			wt[i]=tt[i]-bt[i];
		}
		
		System.out.println();
		System.out.print("Gantt Chart- ");
		for(i=0;i<=time;i++) {
			if(gc[i]==-1) System.out.print(" "+" ");
			else	System.out.print("P"+(gc[i]+1)+" ");
		}
		System.out.println();
		System.out.println();
		System.out.println(" P_id , A.T , B.T , C.T , T.T , W.T ");
		for(i=0;i<n;i++) {
			System.out.println("P"+(i+1)+"-> "+at[i]+" "+bt[i]+" "+ct[i]+" "+tt[i]+" "+wt[i]);
		}
	}
	
	public static void main(String []args) {
		new Model_p();
	}
}