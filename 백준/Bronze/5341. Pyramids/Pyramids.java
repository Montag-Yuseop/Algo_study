import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n = sc.nextInt();
			
			if(n == 0) {
				break;
			}
			
			System.out.println((1+n)*n/2);
			
		}
		
	}

}