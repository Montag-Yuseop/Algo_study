import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int queryCount = Integer.parseInt(st.nextToken());

    int[][] arr = new int[N][M];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < M; c++) {
        arr[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < queryCount; i++) {
      st = new StringTokenizer(br.readLine());
      int query = Integer.parseInt(st.nextToken());

      if (query == 0)
        zeroQuery(
            arr,
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()));
      else oneQuery(arr, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        sb.append(arr[r][c]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  public static void zeroQuery(int[][] arr, int nr, int nc, int k) {
    arr[nr][nc] = k;
  }

  public static void oneQuery(int[][] arr, int firstR, int secondR) {
    int[] temp = arr[firstR];
    arr[firstR] = arr[secondR];
    arr[secondR] = temp;
  }
}