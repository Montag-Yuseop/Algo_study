import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int a = in.nextInt();
        in.close();

        
        for(int i = a; i >= 1; i--) {
        	System.out.println(i);
        }
    }
}
