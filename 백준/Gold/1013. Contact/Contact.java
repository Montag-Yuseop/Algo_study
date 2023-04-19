import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String vega = "(100+1+|01)+";
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			String next = sc.next();
			if(next.matches(vega)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
	}

}