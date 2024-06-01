import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int k = sc.nextInt();
        for(int i = 0; i < k; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            sb.append(n*m/2).append("\n");
        }
        
        System.out.println(sb);
    }
}