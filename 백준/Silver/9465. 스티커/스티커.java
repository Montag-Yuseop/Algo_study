import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][N+1]; // 배열 생성
            int[][] sum = new int[2][N+1];

            // 1. arr에 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            // 정보 바탕으로 sum 배열 초기화
            sum[0][1] = arr[0][1];
            sum[1][1] = arr[1][1];

            for(int i = 2; i <= N; i++) {
                sum[0][i] = Math.max(sum[0][i-2] + arr[1][i-1] + arr[0][i], Math.max(sum[1][i-2] + arr[0][i-1], sum[1][i-2] + arr[0][i]));
                sum[1][i] = Math.max(sum[1][i-2] + arr[0][i-1] + arr[1][i], Math.max(sum[0][i-2] + arr[1][i-1], sum[0][i-2] + arr[1][i]));
            }

            sb.append(Math.max(sum[0][N], sum[1][N])).append("\n");
        }

        System.out.println(sb);
    }
}