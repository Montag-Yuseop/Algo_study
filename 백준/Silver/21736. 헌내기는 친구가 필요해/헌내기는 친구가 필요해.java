import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, cnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        int startR = 0;
        int startC = 0;

        for(int r = 0; r < N; r++){
            String s = br.readLine();
            for(int c = 0;  c < M; c++){
                if(s.charAt(c) == 'I'){
                    startR = r;
                    startC = c;
                }
                map[r][c] = s.charAt(c);
            }
        }
        cnt = 0;
        bfs(startR, startC);
        if(cnt == 0){
            System.out.println("TT");
        } else{
            System.out.println(cnt);
        }
    }
    private static void bfs(int startR, int startC) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startR, startC));
        visited[startR][startC] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int d = 0; d < 4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if(bc(nr, nc) && !visited[nr][nc] && map[nr][nc] != 'X'){
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                    if(map[nr][nc] == 'P') cnt++;
                }
            }
        }
    }

    private static boolean bc(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }

}