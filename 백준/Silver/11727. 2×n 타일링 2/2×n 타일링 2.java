import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] map = new int[n+1];
        int ans = 0;



        if(n > 2){
            map[1] = 1;
            map[2] = 3;
            for(int i = 3; i < n+1; i++){
                map[i] = ((2*map[i-2]) + map[i-1]) % 10007;
                ans = map[n];
            }
        } else{
            if(n == 1){
                ans = 1;
            } else if(n == 2){
                ans = 3;
            }
        }

        System.out.println(ans);

    }
}