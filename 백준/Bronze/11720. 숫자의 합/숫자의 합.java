import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		String b = sc.next();
		sc.close();
		int result = 0;
		
		for(int i=0; i < a; i++) {
			result += b.charAt(i)-'0';
		}
		
		System.out.println(result);
				
	}

}