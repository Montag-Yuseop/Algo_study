import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 제곱수의 합으로 표현
        // 1 = 1 /1
        // 2 = 1 + 1 /2
        // 3 = 1 + 1 + 1 /3
        // 4 = 2 /1
        // 5 = 2 + 1 /2
        // 6 = 2 + 1 + 1 /3
        // 7 = 2 + 1 + 1 + 1 /4
        // 8 = 2 + 2 /2
        // 9 = 3 /1
        // 10 = 3 + 1 /2
        // 11 = 3 + 1 + 1 /3
        // 반복된다
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 입력 N
        int[] dp = new int[N+1]; // dp[0]은 0으로, N값도 찾아야 하기 때문에 N+1

        dp[0] = 0;
        dp[1] = 1;

        int min = 0;
        for(int i = 2; i < N+1; i++){
            min = Integer.MAX_VALUE; // 계속 초기화
            for(int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i-(j*j)]);
            }
            dp[i] = min+1;
        }

        System.out.println(dp[N]);


    }
}