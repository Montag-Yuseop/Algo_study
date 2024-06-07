import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {

    // 180도 회전시켜서 똑같은 숫자를 찾는 것

    // 일단 빠른 구현은 브루트포스
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    Set<Integer> set = new HashSet<>();

    for (int i = N; i <= M; i++) {
      StringBuilder sb = new StringBuilder();
      // 스트링 빌더의 리버스를 활용해보자
      sb.append(i);
      String temp = sb.reverse().toString();
      if (temp.charAt(0) == '0') continue;

      temp = temp.replaceAll("6", "-").replaceAll("9", "6").replaceAll("-", "9");

      if (!check(temp)) continue;

      if (i == Integer.parseInt(temp)) set.add(i);
    }

    System.out.println(set.size());
  }

  public static boolean check(String temp) {
    for (int i = 0; i < temp.length(); i++) {
      char c = temp.charAt(i);
      if (c == '2' || c == '3' || c == '4' || c == '5' || c == '7') return false;
    }
    return true;
  }
}