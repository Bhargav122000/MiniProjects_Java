import java.util.Scanner;

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
	
	Scanner ip= new Scanner(System.in);
	
	public RRS(int []a,int []b,int quantum) {
		//System.out.print("Enter # processes:");
		//n = ip.nextInt();
		
		n = 5;
		
		at = a;
		bt = b;
		ct = new int[n];
		tt = new int[n];
		wt = new int[n];
		dbt = new int[n];
		rq = new int[n];
		
		/*System.out.print("Enter Arrival Times:");
		for(i=0;i<n;i++)	at[i]=ip.nextInt();
		
		System.out.print("Enter Burst Times:");
		for(i=0;i<n;i++)	bt[i]=ip.nextInt();
		
		System.out.print("Enter Time Quantum:");
		Quantum = ip.nextInt();
		*/
		
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
		
		System.out.println("RRS->");
		System.out.println();
		scheduling();
		
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
		System.out.println("before sorting new processes-");
		for(int i1=0;i1<n;i1++)	System.out.print(rq[i1]+" ");
		System.out.println();
		
		for(i=start;i<stop;i++) {
			for(j=start;j<stop-i;j++) {
				if(at[rq[j]] > at[rq[j+1]]) {
					temp = rq[j];
					rq[j] = rq[j+1];
					rq[j+1] = temp;
				}
			}
		}
		
		System.out.println("after sorting new processes-");
		for(int i1=0;i1<n;i1++)	System.out.print(rq[i1]+" ");
		System.out.println();
		
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
					
					for(int i1=0;i1<n;i1++)	System.out.print(rq[i1]+" ");
					System.out.println();
				}
			}
			else if(rq[0]!=-1) {
				done = rq[0];
				for(i=0;i<rq_count-1;i++)	rq[i]=rq[i+1];
				
				rq[i] = -1;
				
				System.out.println("after moving processes-");
				for(int i1=0;i1<n;i1++)	System.out.print(rq[i1]+" ");
				System.out.println();
				
				start = i;
				for(j=0;j<n;j++) {
					if(!present(j) && j != done) {
						if(at[j]<=time && dbt[j]>0)		rq[i++] = j;
					}
				}
				
				System.out.println("before calling sort-");
				for(int i1=0;i1<n;i1++)	System.out.print(rq[i1]+" ");
				System.out.println();
				
				stop = i-1;
				sort_rq(start,stop);
				
				if(dbt[done]>0) 	rq[i++] = done;
				rq_count = i;
				
				System.out.println("Final rq-");
				for(int i1=0;i1<n;i1++)	System.out.print(rq[i1]+" ");
				System.out.println();
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
		
		new Display(ct,tt,wt,gc,time);
		
	}
}