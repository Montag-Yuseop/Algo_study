import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= T; tc++) {
      int K = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      int[] arr = new int[K];
      for (int i = 0; i < K; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      Map<Integer, Integer[]> map = new HashMap<>();
      int N = Integer.parseInt(br.readLine());
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (b == -1 && c == -1) continue;

        map.put(a, new Integer[] {b, c});
      }

      int first = 0;
      int minHour = 100;
      int minMinute = 100;
      int answer = 0;
      for (int i = 0; i < K; i++) {
        Integer[] temp = map.get(arr[i]);
        if (temp == null) continue;

        int tempa = temp[0];
        int tempb = temp[1];

        if (tempa < 6) answer++;
        else if (tempa == 6 && tempb == 0) answer++;

        if (minHour > tempa) {
          minHour = tempa;
          minMinute = tempb;
          first = arr[i];
        } else if (minHour == tempa && minMinute > tempb) {
          minHour = tempa;
          minMinute = tempb;
          first = arr[i];
        }
      }

      System.out.println(first + " " + answer);
    }
  }
}