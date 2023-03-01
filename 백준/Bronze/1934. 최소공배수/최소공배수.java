import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 0; i<T; i++ ) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = uclid(a, b);
			
			int G = c* (a/c) * (b/c);
			System.out.println(G);
			
		}
		
	}

	public static int uclid(int a, int b) {
		if(a%b == 0) {
			return b;
		} else {
			return uclid(b, a%b);
		}
		
	}

}