import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String base = br.readLine();
    String answer = "";
    double maxValue = 0;
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String word = st.nextToken(); // 받아온 단어
      int diff = word.length() - base.length(); // 해당 단어의 길이
      double value = Double.parseDouble(st.nextToken()) / diff; // 나눈 값
      int idx = 0;

      for (int j = 0; j < word.length(); j++) {
        if (base.charAt(idx) == word.charAt(j)) {
          idx++;
          if (idx >= base.length()) break;
        }
      }

      if (idx >= base.length() & maxValue < value) {
        maxValue = value;
        answer = word;
      }
    }

    if (answer.isEmpty()) System.out.println("No Jam");
    else System.out.println(answer);
  }
}