import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int length = s.length();
    int ans = 1_000_000_000;

    // 2번 진행
    // i == 0 -> 0을 1로 바꾸는 횟수
    // i == 1 -> 1을 0으로 바꾸는 횟수
    for (int i = 0; i < 2; i++) {
      int temp = 0;
      boolean check = false;

      for (int j = 0; j < length; j++) {
        int now = s.charAt(j) - '0';
        if (now == i) check = true;
        if (now != i && check) {
          check = false;
          temp++;
        }

        if (j == length - 1 && check) temp++;
      }

      ans = Math.min(ans, temp);
    }

    System.out.println(ans);
  }
}