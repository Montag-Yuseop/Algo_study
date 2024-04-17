import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
        if(n%m ==0 ) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
	}
}