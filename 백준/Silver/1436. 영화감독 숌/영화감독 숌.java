import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = 666;
		int cnt = 1;
		
		int N = sc.nextInt();
		
		while(cnt != N) {
			num++;
			
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
			
		}
		
		System.out.println(num);
	}
}