import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int mid = N-1;
		for(int i = 0; i < 2*N-1; i++) {
			int gap = Math.abs(mid - i);
			for(int j = 0; j < gap; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < 2*(mid-gap)+1; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
	}

}