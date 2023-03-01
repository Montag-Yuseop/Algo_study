import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		
		int[] arr = new int[M-N+1];
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		
		for(int i=0; i<=M-N; i++) {
			arr[i] = N+i;
		}
		
		for(int i=0; i<arr.length; i++) {
			int cnt = 0;
			for(int j=2; j<=arr[i]; j++) {
				if(arr[i]%j == 0) {
					cnt++;
				}
			} if(cnt == 1) {
				sum += arr[i];
				min = Math.min(arr[i], min);
			} 
		}
		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
		
		
	}
}