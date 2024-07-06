import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // N명의 사람
    int K = Integer.parseInt(st.nextToken()); // KmL의 콜라
    int A = Integer.parseInt(st.nextToken()); // 1초에 마실 수 있는 양 A
    int answer = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());

      // t초 동안 마시는 양
      int drink = t * A;

      // 다 마시는데 걸리는 시간, 콜라를 다 마시는데 걸린 시간으로 나눔
      int totalTime = K / drink;

      // 총 걸린 시간 값 저장
      int temp = totalTime * t;

      // 총 휴식 횟수
      int rest = s * totalTime;

      if (K % drink == 0) rest -= s;

      temp += rest;

      if (K % drink != 0) temp += ((K % drink) / A);
      answer = Math.min(answer, temp);
    }
    System.out.println(answer);
  }
}