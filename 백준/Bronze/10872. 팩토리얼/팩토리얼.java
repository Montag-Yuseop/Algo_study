import java.util.Scanner;

public class Main {
	
	public static int fac(int n) {
		if(n==0) {
			return 1;
		} else {
			return n*fac(n-1);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(fac(N));
	}

}