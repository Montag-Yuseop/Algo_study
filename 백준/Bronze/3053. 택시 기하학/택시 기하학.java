import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		double pi = Math.PI;
		
		double circle = pi*n*n;
		
		double taxi = 2*n*n;
		
		System.out.printf("%f %f", circle, taxi);
		
	}
}