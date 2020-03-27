import java.util.*;

public class Target {
	private int overs;
	private int target;
	
	Random r = new Random();
	static Scanner s = new Scanner(System.in);
	
	public void getTarget() {
		this.target = this.overs * (6 + r.nextInt(9));
		System.out.println("Target is - "+this.target);
	}
	
	public static void main(String [] args) {
		Target t = new Target();
		
		System.out.println("Enter the number of overs :");
		t.overs = s.nextInt();
		t.getTarget();
	}
}
