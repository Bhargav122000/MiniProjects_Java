package sum;
import java.util.*;

public class GivenSum {
	
	public static void main(String []args) {
		int n;
		int a[];
		int s[];
		int i,j,k;
		int sum,tsum;
		
		Scanner ip = new Scanner(System.in);
		
		n = ip.nextInt();
		a = new int[n];
		for(i=0;i<n;i++)	a[i] = ip.nextInt();
		s = new int[n];
		for(i=0;i<n;i++)	s[i] = 0;
		sum = ip.nextInt();
		
		int count = 1;
		tsum = sum;
		
		for(i=0;i<n;i++) {
			tsum -= a[i];
			if(tsum >= 0)	{
				s[i] = 1;
				if(tsum == 0)	break;
			}
			else {
				tsum += a[i];
			}
		}
		
		if(tsum == 0) {
			for(i=0;i<n;i++)	System.out.print(s[i]+" ");
			System.out.println();
		}else {
			
		}
	}
}
