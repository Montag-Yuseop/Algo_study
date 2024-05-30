import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long[] a = new long[2];
        a[0] = scanner.nextLong();
        a[1] = scanner.nextLong();

        if(a[0] % 2 == 0 || a[1] % 2 == 0) 
            System.out.println(0);
        else {
            Arrays.sort(a);
            System.out.println(a[0]);
        }

    }
}