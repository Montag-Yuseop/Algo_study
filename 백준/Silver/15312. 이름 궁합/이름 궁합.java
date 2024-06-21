import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String a = br.readLine();
    String b = br.readLine();
    int[] arr = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    for (int i = 0; i < a.length(); i++) {
      sb.append(a.charAt(i)).append(b.charAt(i));
    }

    String sum = sb.toString();

    int[][] dp = new int[sum.length() - 1][sum.length()];

    // 값 초기화
    for (int i = 0; i < dp[0].length; i++) {
      dp[0][i] = arr[sum.charAt(i) - 65];
    }

    for (int r = 1; r < dp.length; r++) {
      for (int c = 0; c < dp[r].length - r; c++) {
        dp[r][c] = (dp[r - 1][c] + dp[r - 1][c + 1]) % 10;
      }
    }

    System.out.println(dp[sum.length() - 2][0] + "" + dp[sum.length() - 2][1]);
  }
}