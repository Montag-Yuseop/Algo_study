import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int odd = Integer.MAX_VALUE;

        for(int i = 0; i < 7; i++) {
            int N = Integer.parseInt(br.readLine());

            if(N % 2 != 0) {
                answer += N;
                odd = Math.min(odd, N);
            }
        }

        if(odd == Integer.MAX_VALUE) System.out.println(-1);
        else {
            System.out.println(answer);
            System.out.println(odd);
        }

    }

}