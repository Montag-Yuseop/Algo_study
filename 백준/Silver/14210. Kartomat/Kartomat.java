import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    String[] arr = new String[N];
    String[][] map = {
      {"*", "*", "*", "A", "B", "C", "D", "E"},
      {"F", "G", "H", "I", "J", "K", "L", "M"},
      {"N", "O", "P", "Q", "R", "S", "T", "U"},
      {"V", "W", "X", "Y", "Z", "*", "*", "*"}
    };
    boolean[][] visited = new boolean[4][8];

    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine();
    }

    String keyword = br.readLine();

    for (int i = 0; i < arr.length; i++) {
      boolean check = true;
      for (int j = 0; j < keyword.length(); j++) {
        if (arr[i].charAt(j) != keyword.charAt(j)) {
          check = false;
          break;
        }
      }
      if (check) arr[i] = arr[i].substring(keyword.length(), keyword.length() + 1);
      else arr[i] = "";
    }

    for (int r = 0; r < map.length; r++) {
      for (int c = 0; c < map[r].length; c++) {
        for (int k = 0; k < arr.length; k++) {
          if (map[r][c].equals(arr[k])) {
            visited[r][c] = true;
          }
        }
      }
    }

    for (int r = 0; r < map.length; r++) {
      for (int c = 0; c < map[r].length; c++) {
        if (visited[r][c]) sb.append(map[r][c]);
        else sb.append("*");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}