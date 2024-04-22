import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {

        // 유저 수 N, 관계 수 M
        // 플로이드-워셜 O(N^3)이므로, 100은 시간초과가 나지 않는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];

        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                if(r == c) map[r][c] = 0;
                else map[r][c] = 100000000;
            }
        }

        // 숫자 저장
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int answer = 0;
        int total = Integer.MAX_VALUE;

        for(int r = 1; r <= N; r++) {
            int temp = 0;

            for(int c = 1; c <= N; c++) {
                temp += map[r][c];
            }

            if(temp < total) {
                total = temp;
                answer = r;
            }

        }

        System.out.println(answer);

    }
}