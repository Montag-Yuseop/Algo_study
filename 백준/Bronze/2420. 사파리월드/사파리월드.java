import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long sub = Math.abs(a-b);
		
		sc.close();
		
		System.out.println(sub);
		
	}
}