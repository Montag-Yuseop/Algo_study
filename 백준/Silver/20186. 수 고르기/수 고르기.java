import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // N개의 자연수가 좌우로 배열, 이 중 K개 고르기
    // 고른 수에서 점수 계산

    // N = 5, 2 3 1 2 1
    // K = 3
    //
    int N = Integer.parseInt(st.nextToken()); // 숫자의 갯수

    int K = Integer.parseInt(st.nextToken()); // 선택할 숫자의 갯수

    int[] arr = new int[N];
    PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      pq.offer(arr[i]);
    }

    // 우측부터 오면서 큰 수를 K개 선택하면 가장 최적의 답이 나올듯
    // pq로 생성해서, 큰 값을 출력하고, K-1까지 모두 더한 값을 출력하면 나올 것 같다
    // 일단 오류가 생길 것 같지만 진행해보자
    int ans = 0;
    int cnt = 0;
    while (cnt < K) {
      ans += pq.poll();
      cnt++;
    }

    ans -= ((K - 1) * K / 2);

    System.out.println(ans);
  }
}