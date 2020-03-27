import java.util.*;

public class LRU {
	private int n;
	private int pages[];
	private int frame[][];
	private int i,j;
	private int position,c_page;
	private int pagefaults;
	
	Scanner ip = new Scanner(System.in);
	
	public LRU() {
		System.out.println("Enter the #pages:");
		n = ip.nextInt();
		
		pages = new int[n];
		System.out.println("Enter "+n+" pages:");
		for(i=0;i<n;i++)	pages[i] = ip.nextInt();
		
		lru();
	}
	
	public int getPosition(int i) {
		int t[],k,min;
		t = new int[3];
		for(j=0;j<3;j++) {
			if(frame[i][j] == -1)	return j;
		}
		
		for(j=0;j<3;j++) {
			for(k=0;k<i;k++) {
				if(pages[k] == frame[i][j])		t[j] = k;
			}
		}
		
		min = 0;
		for(j=0;j<3;j++) {
			if(t[j]<t[min])	min = j;
		}
		return min;
	}
	
	public boolean isPresent(int c_page,int i) {
		for(j=0;j<3;j++) {
			if(frame[i][j] == c_page) return true;
		}
		return false;
	}
	
	public void lru() {
		frame = new int[n][3];
		for(i=0;i<n;i++) {
			for(j=0;j<3;j++)	frame[i][j] = -1;
		}
		position = 0;
		pagefaults = 0;
		
		for(i=0;i<n;i++) {
			if(i!=0) {
				for(j=0;j<3;j++)	frame[i][j] = frame[i-1][j];
			}
			
			c_page = pages[i];
			if(!isPresent(c_page,i)) {
				position = getPosition(i);
				frame[i][position] = c_page;
				pagefaults++;
				//if(position == 2)	position = 0;
				//else				position++;
			}
			
			for(j=0;j<3;j++)	System.out.print(frame[i][j]+" ");
			System.out.println();
		}
		
		System.out.println();
		System.out.println("page faults -"+pagefaults);
		
		for(j=0;j<3;j++) {
			for(i=0;i<n;i++) {
				if(frame[i][j] == -1)	System.out.print(String.format("%3s","-"));
				else	System.out.print(String.format("%3d",frame[i][j]));
			}
			System.out.println();
		}
	}
	
	public static void main(String []args) {
		new LRU();
	}
}
