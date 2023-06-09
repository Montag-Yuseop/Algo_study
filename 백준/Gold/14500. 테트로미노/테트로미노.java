import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static int N, M, ans;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {-1, 1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];
        ans = 0;

        // 맵 생성
        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                map[r][c] = sc.nextInt();
            }
        }

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                visited[r][c] = true;
                dfs(r, c, map[r][c], 1);
                visited[r][c] = false;
            }
        }

        System.out.println(ans);

    }

    private static void dfs(int r, int c, int sum, int dept) {
        if(dept == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(bc(nr, nc) && !visited[nr][nc]){
                if(dept == 2) {
                    visited[nr][nc] = true;
                    dfs(r, c, sum+map[nr][nc], dept+1);
                    visited[nr][nc] = false;
                }

                visited[nr][nc] = true;
                dfs(nr, nc, sum + map[nr][nc], dept+1);
                visited[nr][nc] = false;

            }

        }

    }

    private static boolean bc(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }

}