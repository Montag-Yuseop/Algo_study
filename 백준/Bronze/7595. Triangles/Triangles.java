import java.util.*;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		
		int a = sc.nextInt();
		while(a != 0) {
			for(int i = 1; i <= a; i++) {
				for(int j = 1; j <= i; j++) {
					sb.append("*");
				}
				sb.append("\n");
			}
			a = sc.nextInt();
		}
		sc.close();
        System.out.println(sb);
	}
}