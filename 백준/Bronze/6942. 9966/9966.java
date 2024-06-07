import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    // 속도 개선
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int answer = 0;

    for (int i = N; i <= M; i++) {
      if (check(i)) answer++;
    }

    System.out.println(answer);
  }

  static boolean check(int n) {
    String num = String.valueOf(n);
    int start = 0;
    int end = num.length() - 1;

    while (start <= end) {
      char left = num.charAt(start);
      char right = num.charAt(end);

      if (left == '0' || left == '1' || left == '8') {
        if (left != right) return false;
      } else if (left == '6') {
        if (right != '9') return false;
      } else if (left == '9') {
        if (right != '6') return false;
      } else {
        return false;
      }

      start++;
      end--;
    }

    return true;
  }
}