import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int answer = (int) Math.sqrt(a);
		
		System.out.println("The largest square has side length " + answer + ".");
		sc.close();
	}
}