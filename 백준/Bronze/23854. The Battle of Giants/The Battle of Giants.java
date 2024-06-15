import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int teamA = Integer.parseInt(br.readLine());
    int teamB = Integer.parseInt(br.readLine());

    int winA = teamA / 3;
    int winB = teamB / 3;

    int ans = winA + winB;

    int drawA = teamA % 3;
    int drawB = teamB % 3;

    if (drawA == drawB) System.out.println(winA + " " + drawA + " " + winB);
    else System.out.println(-1);
  }
}