import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    // 1. 시간 복잡도
    // N <= 100,000, NlogN

    // 2. 코드 없는 풀이 과정
    // int N <- input

    // String[] code <- size = N, input
    // 0은 띄어쓰기, 1 ~ 26은 대문자, 27 ~ 52 소문자
    // for(0 ~ code.length())
    // if str.contains( code[index] ) -> y
    // else -> n

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    String base = br.readLine();

    int[] code = new int[53];
    for (int i = 0; i < N; i++) {
      code[Integer.parseInt(st.nextToken())]++;
    }

    boolean isOk = true;
    for (int i = 0; i < base.length(); i++) {
      int now = base.charAt(i);
      if (now == ' ') now = 0;
      else if (now >= 'A' && now <= 'Z') {
        now = now - 'A' + 1;
      } else {
        now = now - 'a' + 27;
      }

      code[now]--;
      if (code[now] < 0) {
        isOk = false;
        break;
      }
    }

    if (isOk) System.out.println("y");
    else System.out.println("n");
  }
}