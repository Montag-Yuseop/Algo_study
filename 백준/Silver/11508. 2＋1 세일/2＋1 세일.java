import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // TestCase 최댓값 100_000 -> NlogN 내의 시간 복잡도로 해결

    // 무게 오름차순으로 정렬해, 뒤에서부터 큰 것끼리 묶는다
    // 큰 무게끼리 묶어야 많이 세일받을 수 있다
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

    for (int i = 0; i < N; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }

    // 이거 PriorityQueue 사용으로 선형 시간내로 해결 가능해서 더 편리하겠다
    int k = 0;
    int answer = 0;

    while (!pq.isEmpty()) {
      int price = pq.poll();
      ++k;
      if (k % 3 == 0) {
        k = 0;
      } else {
        answer += price;
      }
    }
    System.out.println(answer);
  }
}