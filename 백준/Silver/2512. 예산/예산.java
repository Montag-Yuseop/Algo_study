import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /* 예시
     * 전체 국가 예산 485, 각 지방 예산이 120, 110, 140, 150인 경우
     * 상한을 127로 잡으면, 120, 110, 127, 127로 합이 484
     * 총 예산은 N 이상 10억 이하 -> 이진탐색 시간 복잡도 log10억 = 9
     * 각 탐색당 10,000번의 탐색을 통해 가능한지 여부를 확인
     * 총 9만번?
     *
     * 110, 120, 140, 150으로 정렬한 뒤 상한액을 75로 시작(1 ~ 150의 중간)
     * 75씩 반복문을 돌며 만족하는지 확인 (여기선 75 * 4)
     * 만족한다면 -> 75와 150 사이의 중간을 다시 탐색 120정도?
     * 예산의 합을 넘지 않으면서 모두를 만족하는 경우 찾기
     */

    int N = Integer.parseInt(br.readLine()); // 지방의 수
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] budget = new int[N]; // 100,000씩 10,000개여도 10억이므로 int 최대 범위를 넘지 않음
    int maxValue = 0;

    for (int i = 0; i < N; i++) {
      budget[i] = Integer.parseInt(st.nextToken());
      maxValue = Math.max(maxValue, budget[i]);
    }

    int K = Integer.parseInt(br.readLine()); // 예산 최댓값

    int left = 0;
    int right = maxValue;

    int answer = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;

      int sum = 0;
      for (int i = 0; i < N; i++) {
        sum += Math.min(budget[i], mid);
      }

      // 상한액 초과시
      if (sum > K) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
      answer = right;
    }

    System.out.println(answer);
  }
}