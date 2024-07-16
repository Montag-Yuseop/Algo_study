import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] LIS = new int[N];
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    LIS[0] = arr[0];
    int len = 1;

    for (int i = 1; i < N; i++) {
      int num = arr[i];

      if (LIS[len - 1] < num) {
        len++;
        LIS[len - 1] = num;
      } else {
        int l = 0;
        int r = len;

        while (l < r) {
          int mid = l + (r - l) / 2;

          if (LIS[mid] < num) {
            l = mid + 1;
          } else {
            r = mid;
          }
        }
        LIS[l] = num;
      }
    }
    System.out.println(len);
  }
}