import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double w = sc.nextDouble();
		double h = sc.nextDouble();
		double area = w * h / 2;
		
		System.out.println(String.format("%.1f", area));
		sc.close();
	}
}