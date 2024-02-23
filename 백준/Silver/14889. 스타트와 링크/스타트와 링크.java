import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, answer;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // N명
        map = new int[N][N];
        answer = Integer.MAX_VALUE;
        visited = new boolean[N];

        for(int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);

    }

    static void dfs(int depth, int select) {

        // 종료 조건 depth가 N과 같아졌을 때(0부터 시작해서 N-1까지 총 N번 진행)
        if(depth == N / 2) {
            cal();
            return;
        }

        for(int i = select; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }

        }

    }

    static void cal() {
        int start = 0;
        int link = 0;

        for(int i = 0; i < N ; i++) {
            for(int j = i+1; j < N ; j++){
                if (visited[i] && visited[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if(!visited[i] && !visited[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        answer = Math.min(answer, Math.abs(start - link));
    }
}