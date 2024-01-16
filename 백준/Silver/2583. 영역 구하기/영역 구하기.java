import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<Integer> answer = new PriorityQueue<>();
    static int M, N;
    public static void main(String[] args) throws IOException {

        // 직사각형 개수 K
        // 좌측 아래(r, c) / 우측 위(r, c) 주어짐

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // r
        N = Integer.parseInt(st.nextToken()); // c
        int K = Integer.parseInt(st.nextToken());

        // ex) 0, 0 ~ 5, 7까지
        map = new int[M][N];
        visited = new boolean[M][N];

        // map 생성 대칭모양
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int lc = Integer.parseInt(st.nextToken());
            int lr = Integer.parseInt(st.nextToken());
            int rc = Integer.parseInt(st.nextToken());
            int rr = Integer.parseInt(st.nextToken());


            for(int r = lr; r < rr; r++ ) {
                for(int c = lc; c < rc; c++) {
                    map[r][c] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 0) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
        StringBuilder sb = new StringBuilder();
        while (!answer.isEmpty()) {
            sb.append(answer.poll()+" ");
        }

        System.out.println(sb);
    }

    static void bfs(int startR, int startC) {
        Queue<Node> q = new LinkedList<>();
        int count = 1;
        q.offer(new Node(startR, startC));
        visited[startR][startC] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;

            for(int d = 0; d < 4; d++) {
                int nextR = nowR + dr[d];
                int nextC = nowC + dc[d];

                if(bc(nextR, nextC) && map[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                    ++count;
                    q.offer(new Node(nextR, nextC));
                    visited[nextR][nextC] = true;
                }

            }
        }
        answer.offer(count);
    }

    static boolean bc(int r, int c) {
        return r >= 0 && c >= 0 && r < M && c < N;
    }
}