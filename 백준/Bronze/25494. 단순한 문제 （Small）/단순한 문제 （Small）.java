import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      int answer = 0;
      for (int i = 1; i <= a; i++) {
        for (int j = 1; j <= b; j++) {
          int first = i % j;

          for (int k = 1; k <= c; k++) {
            int second = j % k;
            int third = k % i;

            if (first == second && second == third) answer++;
          }
        }
      }
      sb.append(answer).append("\n");
    }
    System.out.println(sb);
  }
}