import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String base = br.readLine();
        String compare = br.readLine();

        int[][] dp = new int[compare.length()+1][base.length()+1];

        for(int i = 1; i <= compare.length(); i++) {
            for(int j = 1; j <= base.length(); j++) {
                // 같은 경우
                if(compare.charAt(i-1) == base.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                // 다른 경우
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }

        System.out.println(dp[compare.length()][base.length()]);

    }

}