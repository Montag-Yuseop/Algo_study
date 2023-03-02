import java.util.Scanner;

public class Main {
	public static int N;
	public static boolean check;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		dfs(0, N);
		System.out.println(sb);

	}

	private static void dfs(int num, int cnt) {
		if(cnt == 0) {
			if(isPrime(num)) {
				sb.append(num+"\n");
			}
			return;
		}
		
		for(int i=0; i<10; i++) {
			int nextNum = 10*num+i;
			if(isPrime(nextNum)) {
				dfs(nextNum, cnt-1);
			}
		}
		
	}

	private static boolean isPrime(int num) {
		if(num < 2) return false;
		
		for(int i = 2; i<= Math.sqrt(num); i++) {
			if(num%i == 0) return false;
		}
		
		return true;
	}


}