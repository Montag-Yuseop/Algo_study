import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		
		int ans = 0;
		
		if(N == 1) 
			ans = 1;
		
		else {
			for(int i = 1; i<=N; i++) {
				for(int j = i; j*i<=N; j++) {
					ans++;
				}
			}

		}
		
		System.out.println(ans);
	}
}