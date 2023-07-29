import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(c == 'b') {
                    N--;
                } else {
                    N++;
                }
            }

            sb.append("Data Set "+tc+":\n");
            if(tc == T) {
                sb.append(N);
            } else {
                sb.append(N+"\n\n");
            }

        }
        System.out.println(sb);

    }
}