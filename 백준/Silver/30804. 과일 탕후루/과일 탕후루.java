import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] fruit = new int[N]; // 과일 정보 저장
    int[] totalFruit = new int[10];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      fruit[i] = Integer.parseInt(st.nextToken());
    }

    int answer = 0;
    int left = 0;
    int right = 0;
    int kind = 0;
    int count = 0;

    while (right < N) {
      // 현재 과일이 0개였다면 새로운 종류가 들어오는 것으로 인식
      if (totalFruit[fruit[right]] == 0) {
        kind++;
      }

      totalFruit[fruit[right]]++; // 현재 과일 종류 개수 증가
      count++; // 지금까지 꽂은 과일 증가

      if (kind > 2) {
        totalFruit[fruit[left]]--;
        count--;

        if (totalFruit[fruit[left]] == 0) {
          kind--;
        }

        left++;
      }
      answer = Math.max(answer, count);
      right++;
    }

    System.out.println(answer);
  }
}