import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // 1, 1, 3, 7, 8
    // 1, 3, 6
    // 정렬 후 탐색을 통해 진행

    int T = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int[] sizeA = new int[N];
      int[] sizeB = new int[M];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        sizeA[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) {
        sizeB[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(sizeA);
      Arrays.sort(sizeB);

      int answer = 0;
      for (int i = 0; i < N; i++) {
        int now = sizeA[i];
        int start = 0;
        int end = M - 1;

        while (start <= end) {
          int mid = (start + end) / 2;
          if (now <= sizeB[mid]) {
            end = mid - 1;
          } else {
            start = mid + 1;
          }
        }
        answer += start;
      }
      sb.append(answer).append("\n");
    }
    System.out.println(sb);
  }
}