import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(x == 0 && y == 0) break;
			
			String s = (x > y) ? "Yes" : "No";
			
			System.out.println(s);
			
			
		}
		
		sc.close();
		
	}

}