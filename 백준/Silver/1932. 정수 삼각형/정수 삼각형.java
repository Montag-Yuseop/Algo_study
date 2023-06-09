import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        for(int r = 0; r < N; r++){
            for(int c = 0; c < r+1; c++){
                arr[r][c] = sc.nextInt();
            }
        }

        dp[0][0] = arr[0][0];

        for(int i = 1; i < N; i++){
            dp[i][0] += dp[i-1][0] + arr[i][0];
            dp[i][i]+= dp[i-1][i-1] + arr[i][i];
        }

        for(int r = 1; r < N; r++){
            for(int c = 1; c < r; c++){
                dp[r][c] = Math.max(dp[r-1][c-1], dp[r-1][c]) + arr[r][c];
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++){
            ans = Math.max(ans, dp[N-1][i]);
        }
        System.out.println(ans);
    }
}