import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int answer = 0;

    for (int r = 0; r < N; r++) {
      String s = br.readLine();
      for (int c = 0; c < M; c++) {
        if (s.charAt(c) == '0') {
          int cnt = 0;
          for (int i = c; i < M; i++) {
            if (s.charAt(i) == '0') cnt++;

            if (cnt == K) {
              answer++;
              break;
            }

            if (s.charAt(i) == '1') break;
          }
        }
      }
    }
    System.out.println(answer);
  }
}