import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        
        System.out.println(a * (b%10));
        System.out.println(a * ((b%100)/10));
        System.out.println(a * (b/100));
        System.out.println(a*b);
        
        in.close();
        
    }
}