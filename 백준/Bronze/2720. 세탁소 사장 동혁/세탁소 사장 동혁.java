import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] change = {25, 10, 5, 1};
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] ans = new int[4];

            for(int i = 0; i < change.length; i++) {
                ans[i] = N / change[i];
                N %= change[i];
            }

            for(int i : ans) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}