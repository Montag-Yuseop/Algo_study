import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		int sum = 0;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			int a = sc.nextInt();
			sum += a*a;
		}
		sc.close();
		
		System.out.println(sum % 10);

	}
}