import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int A = in.nextInt();
        
        if(A%4==0) {
            if(A%400==0) System.out.println("1");
            else if(A%100==0) System.out.println("0");
            else System.out.println("1");
        }
        else System.out.println("0");
    }
}