import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long N = Long.parseLong(br.readLine());
    int answer = 0;

    while (N > 3) {
      N = N / 2 + (N % 2 == 0 ? 0 : 1);
      answer++;
      //      System.out.println("N = " + N);
    }

    System.out.println(answer + N);
  }
}