import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int correctCount = Integer.parseInt(br.readLine());

    char[] friendAnswer = br.readLine().toCharArray();
    char[] myAnswer = br.readLine().toCharArray();

    // 배열 길이 돌면서 최대한 같은 것을 정답으로 처리
    int answer = 0;
    int same = 0;
    int diff = 0;

    for (int i = 0; i < friendAnswer.length; i++) {
      if (friendAnswer[i] == myAnswer[i]) same++;
      else diff++;
    }

    // 친구가 맞은 갯수에서 나랑 같은게 몇 개인지 센다
    // 친구가 맞은건 correctCount, 틀린건 전체 - correctCount
    answer += Math.min(correctCount, same);
    answer += Math.min(friendAnswer.length - correctCount, diff);

    System.out.println(answer);
  }
}