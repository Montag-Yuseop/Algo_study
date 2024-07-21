import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int answer = 0;

    // 시간 복잡도 계산
    // N은 1,000 -> N^2, N^2 logN도 가능

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = i; j < N; j++) {
        list.add(arr[i] + arr[j]);
      }
    }

    // 중복을 제거하고 리스트에 입력
    Collections.sort(list);

    // 배열을 뒤에서 돌면서 j가 0부터 i전까지 수를 차례로 빼보며
    // 이분 탐색 진행
    outer:
    for (int i = N - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        int temp = arr[i] - arr[j];
        // 두 수를 더한 리스트를 이분탐색하며 temp 값이 있는지 찾아야 함
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
          int mid = (start + end) / 2;
          if (list.get(mid) == temp) {
            answer = arr[i];
            break outer;
          } else if (list.get(mid) < temp) {
            start = mid + 1;
          } else {
            end = mid - 1;
          }
        }
      }
    }
    System.out.println(answer);
  }
}