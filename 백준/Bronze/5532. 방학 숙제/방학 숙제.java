import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        double C = sc.nextDouble();
        double D = sc.nextDouble();

        int max = (int) Math.max(Math.ceil(A/C), Math.ceil(B/D));
        System.out.println(L-max);

    }
}