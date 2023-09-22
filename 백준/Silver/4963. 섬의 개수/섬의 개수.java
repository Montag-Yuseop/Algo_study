import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static boolean[][] visited;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1,1 };
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] map;
    static int r, c;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            // 종료 조건
            if(c == 0 && r == 0) break;

            map = new int[r][c];
            visited = new boolean[r][c];

            for(int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < c; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    if(!visited[i][j] && map[i][j] == 1){
                        dfs(i, j);
                        cnt++;

                    }
                }
            }

            System.out.println(cnt);


        }

    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;

        for(int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(bc(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }

    public static boolean bc(int nr, int nc) {
        return nr >= 0 && nr < r && nc >= 0 && nc < c;
    }

}