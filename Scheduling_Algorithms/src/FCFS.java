import java.util.Scanner;

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
	
	Scanner ip= new Scanner(System.in);
	
	public FCFS(int a[],int b[]) {
		//System.out.print("Enter # processes:");
		//n = ip.nextInt();
		n = 5;
		
		at = new int[n];
		bt = new int[n];
		ct = new int[n];
		tt = new int[n];
		wt = new int[n];
		dbt = new int[n];
		rq = new int[n];
		
		/*System.out.print("Enter Arrival Times:");
		for(i=0;i<n;i++)	at[i]=ip.nextInt();
		
		System.out.print("Enter Burst Times:");
		for(i=0;i<n;i++)	bt[i]=ip.nextInt();*/
		setArrivalTimes(a);
		setBurstTimes(b);
		for(i=0,gc_length=0;i<n;i++) {
			ct[i]=-1;
			tt[i]=-1;
			wt[i]=-1;
			rq[i]=-1;
			//dbt[i]=bt[i];
			gc_length+=bt[i];
		}
		
		gc_length = gc_length*2;
		gc = new int[gc_length];
		for(i=0;i<gc_length;i++)	gc[i]=-1;
		
		/*System.out.println("FCFS->");
		System.out.println();*/
		scheduling();
		
	}
	
	public void setArrivalTimes(int []a) {
		for(i=0;i<n;i++)	at[i] = a[i];
	}
	
	public void setBurstTimes(int []a) {
		for(i=0;i<n;i++) {
			bt[i] = a[i];
			dbt[i] = a[i];
		}
	}
	
	public int[] getArrivalTimes(){
		return at;
	}
	
	public int[] getBurstTimes(){
		return bt;
	}
	
	public int[] getDBurstTimes(){
		return dbt;
	}
	
	public int[] getCompleteTimes() {
		return ct;
	}
	
	public int[] getTurnAroundTimes() {
		return tt;
	}
	
	public int[] getWaitingTimes() {
		return wt;
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
				/*System.out.println();
				System.out.print("Ready Queue - ");
				System.out.println();*/
				i=0;
				while(rq[i]!=-1) {
					j = rq[i];
					//System.out.print("P"+(j+1)+" ");
					while(dbt[j] != 0) {
						gc[time]=j;
						time=time+1;
						dbt[j]=dbt[j]-1;
					}
					
					if(dbt[j]==0) {
						ct[j]=time;
						//System.out.println(ct[j]);
					}
					i++;
				}
			}
		}
		
		for(i=0;i<n;i++) {
			tt[i]=ct[i]-at[i];
			wt[i]=tt[i]-bt[i];
		}
		
		
		new Display(ct,tt,wt,gc,time);
		System.out.println();
		System.out.print("Completion times-");
		for(i=0;i<n;i++)	System.out.print(ct[i]+" ");
		System.out.println();
		System.out.print("TurnAround times-");
		for(i=0;i<n;i++)	System.out.print(tt[i]+" ");
		System.out.println();
		System.out.print("Waiting times-");
		for(i=0;i<n;i++)	System.out.print(wt[i]+" ");
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
	
}
