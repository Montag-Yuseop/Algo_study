import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		
		int i;
		for(i = 0; i < n.length(); i++) {
			if(n.charAt(i) == '7') {
				break;
			}
		}
		
		int num = Integer.parseInt(n);
		if(i == n.length() && num % 7 != 0) {
			System.out.println("0");
		}else if(i == n.length() && num % 7 == 0) {
			System.out.println("1");
		}else if(i != n.length() && num % 7 != 0) {
			System.out.println("2");
		}else if(i != n.length() && num % 7 == 0) {
			System.out.println("3");
		}
		sc.close();
	}
}