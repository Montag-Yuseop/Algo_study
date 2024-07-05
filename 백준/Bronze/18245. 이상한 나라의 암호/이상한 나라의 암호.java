import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int idx = 2;
    while (true) {
      String s = br.readLine();

      if (s.equals("Was it a cat I saw?")) break;
      for (int i = 0; i < s.length(); i += idx) {
        sb.append(s.charAt(i));
      }
      sb.append("\n");
      idx++;
    }

    System.out.println(sb);
  }
}