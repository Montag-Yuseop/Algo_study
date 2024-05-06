import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][N + 1];

        for(int i = 0; i <= N; i++) {
            dp[i][1] = i;
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                dp[i][j] %= 10007;
            }
        }

        System.out.println(dp[N][K]);

    }
}