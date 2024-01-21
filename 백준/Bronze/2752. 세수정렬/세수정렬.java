import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] answer = new int[3];

        for (int i = 0; i < 3; i++) {
            int x = Integer.parseInt(st.nextToken());

            answer[i] = x;
        }

        Arrays.sort(answer);

        for (int i = 0; i < 3; i++) {
            System.out.print(answer[i] + " ");
        }

    }

}