import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int ans;
		
		if(N%5 != 0) {
			ans = N/5+1; 
		} else {
			ans = N/5;
		}
		
		System.out.println(ans);
	}
}