import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 공주님을 구해라!
    // N * M 크기의 성
    // 0,0에 용사
    // N-1, M-1에 공주
    // 2는 마법검 그람의 위치(벽을 부술 수 있다)
    // 벽은 1로 나타낸다
    // 그람으로 벽을 부수는 경우... 그 제한은 없다
    // T 시간 내에 도달

    public static class Node {
        int r, c, cnt;
        boolean gram;
        public Node(int r, int c, boolean gram, int cnt) {
            this.r = r;
            this.c = c;
            this.gram = gram;
            this.cnt = cnt;
        }
    }
    static int N, M, T, ans;
    static int[][] map;

    // 그람을 먹은 경우와 아닌 경우로 나눠서 생각해보면 될듯
    static boolean[][][] visited;
    static int[] dr = {0, 0 , 1, -1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // 맵과 방문배열 생성
        map = new int[N][M];
        visited = new boolean[N][M][2];

        // 성 생성
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;
        bfs(); // 탐색 진행

        if(ans == Integer.MAX_VALUE) {
            System.out.println("Fail");
        } else {
            System.out.println(ans);
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, false, 0));
        visited[0][0][0] = true; // 처음 시작 위치는 방문처리
        visited[0][0][1] = true; // 칼 먹어도 여긴 방문처리

        while(!q.isEmpty()) {
            // 그람을 먹은 경우와 안 먹은 경우로 나누어서 진행해야 한다
            // 그람을 먹은 경우는 3차원 방문 배열의 끝을 1로
            // 안 먹은 경우는 끝을 0으로 진행하면 된다
            // 그런데 먹은 경우와 안 먹은 경우로 나누는 방법을 고려해야 한다
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;
            boolean isGram = cur.gram;
            int cnt = cur.cnt;

            if(nowR == N-1 && nowC == M-1 && cnt <= T) {
                ans = Math.min(ans, cnt);
            }

            for(int d = 0; d < 4; d++) {
                int nextR = nowR + dr[d];
                int nextC = nowC + dc[d];

                // 일단 범위 내에서
                if(bc(nextR, nextC)) {
                    // 그람이 없는 경우
                    if(!isGram) {
                        if (!visited[nextR][nextC][0] && map[nextR][nextC] == 0) {
                           visited[nextR][nextC][0] = true;
                           q.offer(new Node(nextR, nextC, false, cnt+1));
                        } else if(!visited[nextR][nextC][0] && map[nextR][nextC] == 2) {
                            visited[nextR][nextC][0] = true;
                            q.offer(new Node(nextR, nextC, true, cnt+1));
                        }
                    } else { // 그람이 있는 경우
                        if(!visited[nextR][nextC][1]) {
                            visited[nextR][nextC][1] = true;
                            q.offer(new Node(nextR, nextC, true, cnt+1));
                        }
                    }

                }


            }


        }

    }
    public static boolean bc(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}