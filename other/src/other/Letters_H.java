package other;
import java.util.*;

public class Letters_H {
	Scanner ip = new Scanner(System.in);
	String str;
	int z[][][];
	
	public Letters_H() {
		System.out.println("Enter a string:");
		str = ip.nextLine();
		z = new int[str.length()][5][5];
	}
	
	public void display() {
		int i;
		
		for(i=0;i<str.length();i++) {
			if((str.charAt(i)>='A' || str.charAt(i)>='a') && (str.charAt(i)<='Z' || str.charAt(i)<='z'))	continue;
			else {
				System.out.println("Try to give a string of alphabet");
				return;
			}
		}
		str = str.toUpperCase();
		
		for(i=0;i<str.length();i++) {
			display_0(str.charAt(i),i);
			display_1(str.charAt(i),i);
			display_2(str.charAt(i),i);
			display_3(str.charAt(i),i);
			display_4(str.charAt(i),i);
		}
		
		for(int j=0;j<5;j++) {
			for(i=0;i<str.length();i++) {
				for(int k=0;k<5;k++) {
					if(z[i][j][k] == 1)		System.out.print(String.format("%2s","[|"));
					else					System.out.print(String.format("%2s",""));
				}
				System.out.print("	");
			}
			System.out.println();
		}
	}
	
	public void display_0(char c,int i) {
		int j;
		for(j=0;j<5;j++) {
			if(c=='A' || c=='M' || c=='O' || c=='Q') {
				if(j==1 || j==2 || j==3)	z[i][0][j] = 1;
				else						z[i][0][j] = 0;
			}
			if(c=='B' || c=='D' || c=='P' || c=='R') {
				if(j==0 || j==1 || j==2 || j==3) 	z[i][0][j] = 1;
				else								z[i][0][j] = 0;
			}
			if(c=='C' || c=='E' || c=='F' || c=='G' || c=='S') {
				if(j==1 || j==2 || j==3 || j==4)	z[i][0][j] = 1;
				else								z[i][0][j] = 0;
			}
			if(c=='H' || c=='K' || c=='N' || c=='U' || c=='V' || c=='W' || c=='X' || c=='Y') {
				if(j==0 || j==4)	z[i][0][j] = 1;
				else				z[i][0][j] = 0;
			}
			if(c=='I' || c=='J' || c=='T' || c=='Z') {
				z[i][0][j] = 1;
			}
			if(c=='L') {
				if(j==0)	z[i][0][j] = 1;
				else		z[i][0][j] = 0;
			}
		}
	}
	
	public void display_1(char c,int i) {
		int j;
		for(j=0;j<5;j++) {
			if(c=='A' || c=='B' || c=='D' || c=='H' || c=='O' || c=='P') {
				if(j==0 || j==4)	z[i][1][j] = 1;
				else				z[i][1][j] = 0;
			}
			if(c=='Q' || c=='R' || c=='U' || c=='V' || c=='W' || c=='Y') {
				if(j==0 || j==4)	z[i][1][j] = 1;
				else				z[i][1][j] = 0;
			}
			if(c=='C' || c=='E' || c=='F' || c=='G' || c=='L' || c=='S') {
				if(j==0)	z[i][1][j] = 1;
				else		z[i][1][j] = 0;
			}
			if(c=='I' || c=='T') {
				if(j==2)	z[i][1][j] = 1;
				else		z[i][1][j] = 0;
			}
			if(c=='J' || c=='Z') {
				if(j==3)	z[i][1][j] = 1;
				else		z[i][1][j] = 0;
			}
			if(c=='K') {
				if(j==0 || j==3)	z[i][1][j] = 1;
				else				z[i][1][j] = 0;			}
			if(c=='M') {
				if(j==0 || j==2 || j==4)	z[i][1][j] = 1;
				else						z[i][1][j] = 0;			}
			if(c=='N') {
				if(j==0 || j==1 || j==4)	z[i][1][j] = 1;
				else						z[i][1][j] = 0;
			}
			if(c=='X') {
				if(j==1 || j==3)	z[i][1][j] = 1;
				else				z[i][1][j] = 0;
			}
		}
	}
	
	public void display_2(char c,int i) {
		int j;
		for(j=0;j<5;j++) {
			if(c=='A' || c=='E' || c=='F' || c=='H') {
				z[i][2][j] = 1;
			}
			if(c=='B' || c=='P' || c=='R') {
				if(j==0 || j==1 || j==2 || j==3)	z[i][2][j] = 1;
				else								z[i][2][j] = 0;
			}
			if(c=='C' || c=='L') {
				if(j==0)	z[i][2][j] = 1;
				else		z[i][2][j] = 0;
			}
			if(c=='D' || c=='O' || c=='U' || c=='V') {
				if(j==0 || j==4)	z[i][2][j] = 1;
				else				z[i][2][j] = 0;
			}
			if(c=='G') {
				if(j==0 || j==3 || j==4)	z[i][2][j] = 1;
				else						z[i][2][j] = 0;
			}
			if(c=='I' || c=='T' || c=='X' || c=='Z') {
				if(j==2)	z[i][2][j] = 1;
				else		z[i][2][j] = 0;
			}
			if(c=='J') {
				if(j==3)	z[i][2][j] = 1;
				else		z[i][2][j] = 0;
			}
			if(c=='K') {
				if(j==0 || j==1 || j==2)	z[i][2][j] = 1;
				else						z[i][2][j] = 0;
			}
			if(c=='M' || c=='N' || c=='Q' || c=='W') {
				if(j==0 || j==2 || j==4)	z[i][2][j] = 1;
				else						z[i][2][j] = 0;
			}
			if(c=='S') {
				if(j==1 || j==2 || j==3)	z[i][2][j] = 1;
				else						z[i][2][j] = 0;
			}
			if(c=='Y') {
				if(j==1 || j==2 || j==3 || j==4)	z[i][2][j] = 1;
				else								z[i][2][j] = 0;
			}
		}
	}
	
	public void display_3(char c,int i) {
		int j;
		for(j=0;j<5;j++) {
			if(c=='A' || c=='B' || c=='D' || c=='G' || c=='H' || c=='M' || c=='O' || c=='U') {
				if(j==0 || j==4)	z[i][3][j] = 1;
				else				z[i][3][j] = 0;
			}
			if(c=='C' || c=='E' || c=='F' || c=='L' || c=='P') {
				if(j==0)	z[i][3][j] = 1;
				else		z[i][3][j] = 0;
			}
			if(c=='I' || c=='T') {
				if(j==2)	z[i][3][j] = 1;
				else		z[i][3][j] = 0;
			}
			if(c=='J' || c=='K' || c=='R') {
				if(j==0 || j==3)	z[i][3][j] = 1;
				else				z[i][3][j] = 0;
			}
			if(c=='N' || c=='Q') {
				if(j==0 || j==3 || j==4)	z[i][3][j] = 1;
				else						z[i][3][j] = 0;
			}
			if(c=='S' || c=='Y') {
				if(j==4)	z[i][3][j] = 1;
				else		z[i][3][j] = 0;
			}
			if(c=='V' || c=='X') {
				if(j==1 || j==3)	z[i][3][j] = 1;
				else				z[i][3][j] = 0;
			}
			if(c=='W') {
				if(j==0 || j==2 || j==4)	z[i][3][j] = 1;
				else						z[i][3][j] = 0;
			}
			if(c=='Z') {
				if(j==1)	z[i][3][j] = 1;
				else		z[i][3][j] = 0;
			}
		}
	}
	
	public void display_4(char c,int i) {
		int j;
		for(j=0;j<5;j++) {
			if(c=='A' || c=='H' || c=='K' || c=='M' || c=='N' || c=='R' || c=='X') {
				if(j==0 || j==4)	z[i][4][j] = 1;
				else				z[i][4][j] = 0;
			}
			if(c=='B' || c=='D' || c=='S') {
				if(j==0 || j==1 || j==2 || j==3)	z[i][4][j] = 1;
				else								z[i][4][j] = 0;
			}
			if(c=='C' || c=='E' || c=='G' || c=='L' || c=='Q') {
				if(j==1 || j==2 || j==3 || j==4)	z[i][4][j] = 1;
				else								z[i][4][j] = 0;;
			}
			if(c=='F' || c=='P') {
				if(j==0)	z[i][4][j] = 1;
				else		z[i][4][j] = 0;
			}
			if(c=='I' || c=='Z') {
				z[i][4][j] = 1;
			}
			if(c=='J') {
				if(j==1 || j==2)	z[i][4][j] = 1;
				else				z[i][4][j] = 0;
			}
			if(c=='T' || c=='V') {
				if(j==2)	z[i][4][j] = 1;
				else		z[i][4][j] = 0;
			}
			if(c=='O' || c=='U' || c=='W' || c=='Y') {
				if(j==1 || j==2 || j==3)	z[i][4][j] = 1;
				else						z[i][4][j] = 0;
			}
		}
	}
	
	public static void main(String []args) {
		Letters_H obj = new Letters_H();
		obj.display();
	}

}
