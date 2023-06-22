import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for(int tc = 1; tc < C+1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            double sum = 0;
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            double avg = sum / N;
            double cnt = 0;
            for(int i = 0; i < N; i++) {
                if(arr[i] > avg) {
                    cnt++;
                }
            }

            System.out.printf("%.3f%%\n", (cnt/N)*100);

        }
    }
}