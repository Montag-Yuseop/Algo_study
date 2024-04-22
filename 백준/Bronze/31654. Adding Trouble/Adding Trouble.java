import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        
        if(x+y == z)
            System.out.println("correct!");
        else
            System.out.println("wrong!");
        
        sc.close();
    }
}