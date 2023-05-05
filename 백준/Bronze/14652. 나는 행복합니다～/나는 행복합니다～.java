import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int cnt = -1;
		
		outer: for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				cnt++;
				if(cnt == K) {
					System.out.println(r + " " + c);
					break outer;
				}
			}
		}
		
	}

}