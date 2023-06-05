import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int tc = 0; tc<T; tc++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(x % 10 == 0){
                sb.append(10 +"\n");
                continue;
            }

            int n = x % 10;

            for(int i = 1; i < y; i++){
                n = (n*x)%10;
            }
            sb.append(n + "\n");

        }
        System.out.println(sb);
    }
}