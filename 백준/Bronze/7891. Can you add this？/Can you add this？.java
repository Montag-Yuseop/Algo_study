import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i =0 ; i < t; i++) {
			BigInteger a = sc.nextBigInteger();
			BigInteger b = sc.nextBigInteger();
			
			System.out.println(a.add(b));
			
		}
		
	}

}