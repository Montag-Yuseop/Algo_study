import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        for(int n = 1; n <= N; n++) {
        	int a = in.nextInt();
        	int b = in.nextInt();
        	
        	System.out.println(a+b);
        }
    }
}
