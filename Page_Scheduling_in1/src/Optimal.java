public class Optimal {
	private int n;
	private int pages[];
	private int frame[][];
	private int i,j;
	private int position,c_page;
	private int pagefaults;

	public Optimal(int []a) {
		n = 15;
		pages = new int[n];
		for(i=0;i<n;i++)	pages[i] = a[i];
	}
	
	public int getPosition(int i) {
		int t[],k,max;
		t = new int[3];
		for(j=0;j<3;j++)	t[j] = -1;
		for(j=0;j<3;j++) {
			if(frame[i][j] == -1)	return j;
		}
		
		for(j=0;j<3;j++) {
			for(k=n-1;k>=i;k--) {
				if(pages[k] == frame[i][j]) {
					t[j] = k;
				}
			}
		}
		
		max = 0;
		for(j=0;j<3;j++) {
			if(t[j] == -1)	return j;
			if(t[j]>t[max])	max = j;
		}
		return max;
	}
	
	public boolean isPresent(int c_page,int i) {
		for(j=0;j<3;j++) {
			if(frame[i][j] == c_page) return true;
		}
		return false;
	}
	
	public int[][] optimal() {
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
			}
		}
		
		return frame;
	}
	
	public int getPageFaults() {
		return pagefaults;
	}
}
