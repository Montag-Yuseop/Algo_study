import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  static int answer;
  static Set<Integer> set = new HashSet<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    answer = 0;

    dfs(N, 0, 0, 0);

    System.out.println(set.size());
  }

  public static void dfs(int N, int depth, int index, int sum) {
    if (depth == N) {
      set.add(sum);
      return;
    }

    for (int i = index; i < 4; i++) {
      int temp = 0;
      if (i == 0) temp = 1;
      if (i == 1) temp = 5;
      if (i == 2) temp = 10;
      if (i == 3) temp = 50;

      dfs(N, depth + 1, i, sum + temp);
    }
  }
}