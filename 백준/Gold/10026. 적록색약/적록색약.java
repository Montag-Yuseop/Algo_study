import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Node{
        int r, c;
        char s;

        public Node(int r, int c, char s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    static char[][] map;
    static int N;
    static boolean[][] visited1, visited2;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        for(int r = 0; r < N; r++){
            map[r] = br.readLine().toCharArray();
        }
        int ans1 = 0;
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(!visited1[r][c]){
                    nomal(r, c);
                    ans1++;
                }
            }
        }

        int ans2 = 0;
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(!visited2[r][c]){
                    greenRed(r, c);
                    ans2++;
                }
            }
        }

        System.out.println(ans1 + " "+ans2);

    }

    private static void greenRed(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r,c, map[r][c]));
        visited2[r][c] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int d = 0; d < 4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if(bc(nr, nc) && !visited2[nr][nc] && cur.s == map[nr][nc]){
                    visited2[nr][nc] = true;
                    q.offer(new Node(nr, nc, map[nr][nc]));
                } else if(bc(nr, nc) && !visited2[nr][nc] && ((cur.s == 'G' && map[nr][nc] == 'R') || (cur.s == 'R' && map[nr][nc] == 'G'))){
                    visited2[nr][nc] = true;
                    q.offer(new Node(nr, nc, map[nr][nc]));
                }
            }
        }
    }

    private static void nomal(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r,c, map[r][c]));
        visited1[r][c] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int d = 0; d < 4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if(bc(nr, nc) && !visited1[nr][nc] && cur.s == map[nr][nc]){
                    visited1[nr][nc] = true;
                    q.offer(new Node(nr, nc, map[nr][nc]));
                }
            }
        }
    }

    private static boolean bc(int nr, int nc) {
        return nr>=0 && nc >= 0 && nr<N && nc<N;
    }
}