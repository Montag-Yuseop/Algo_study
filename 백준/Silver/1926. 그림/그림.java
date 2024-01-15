import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int r, c, value;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    static int n, m, countPaint, maxPaint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        maxPaint = 0;


        for(int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(!visited[r][c] && map[r][c] == 1) {
                    ++countPaint;
                    bfs(r, c);
                }
            }
        }
        System.out.println(countPaint);
        System.out.println(maxPaint);

    }

    static void bfs(int row, int col) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row, col));
        int cnt = 1;
        visited[row][col] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(bc(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    cnt++;
                    q.offer(new Node(nr, nc));
                }
            }
        }
        maxPaint = Math.max(maxPaint, cnt);
    }

    static boolean bc(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < n && nc < m;
    }

}