import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String s = br.readLine();
    char[] arr = {'p', 'P', 'A', 'p'};
    int answer = 0;

    for (int i = 0; i < N; i++) {
      char now = s.charAt(i);

      if (now == 'p') {
        boolean check = false;
        for (int j = 1; j < 4 && i + j < N; j++) {
          if (s.charAt(i + j) == arr[j]) check = true;
          else {
            check = false;
            break;
          }
        }

        if (check) {
          answer++;
          i += 3;
        }
      }
    }
    System.out.println(answer);
  }
}