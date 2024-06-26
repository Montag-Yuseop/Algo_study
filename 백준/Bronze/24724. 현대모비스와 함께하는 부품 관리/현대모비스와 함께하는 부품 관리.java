import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    int T = Integer.parseInt(br.readLine()); // 부품 관리 횟수

    for (int tc = 1; tc <= T; tc++) {
      int N = Integer.parseInt(br.readLine()); // 부품 개수

      StringTokenizer st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken()); // 그룹 부품의 크기
      int b = Integer.parseInt(st.nextToken()); // 무게의 합 최대

      int size = 0;
      int weight = 0;

      for (int i = 1; i <= N; i++) {
        st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken()); // 부품 크기
        int second = Integer.parseInt(st.nextToken()); // 부품 무게
      }
      sb.append("Material Management ")
          .append(tc)
          .append("\n")
          .append("Classification ---- End!")
          .append("\n");
    }
    System.out.println(sb);
  }
}