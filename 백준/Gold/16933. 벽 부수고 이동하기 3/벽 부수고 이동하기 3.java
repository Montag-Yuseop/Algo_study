import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int r, c, value, crush;
        boolean dayAndNight, stay; // 낮 밤 체크(true면 낮, false면 밤으로 생각)
        // 다만 계속 머물수는 없고, 한 번만 머물면 되기 때문에 stay 변수를 통해 머무른 적이 있는지를 저장한다
        public Node(int r, int c, int value, int crush, boolean dayAndNight, boolean stay) {
            this.r = r;
            this.c = c;
            this.value = value;
            this.crush = crush;
            this.dayAndNight = dayAndNight;
            this.stay = stay;
        }
    }

    static int N, M, K, answer;
    static int[][] map;
    static boolean[][][] visited;

    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = -1;

        map = new int[N][M];
        visited = new boolean[N][M][K+1];

        for(int r = 0; r < N; r++) {
            String s = br.readLine();
            for(int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c) - '0';
            }
        }

        bfs();

        System.out.println(answer);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0, true, false));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int value = cur.value;
            int crush = cur.crush;
            boolean dayAndNight = cur.dayAndNight;
            boolean stay = cur.stay;

            if(r == N - 1 && c == M - 1) {
                answer = value;
                return;
            }

            for(int d = 0; d < 5; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                int nValue = value + 1;
                boolean nDayAndNight = !dayAndNight;

                // 경계조건 설정
                if(!bc(nr, nc)) continue;

                // 제자리인 경우
                if(nr == r && nc == c && !stay) { // 머무른 적이 없으면
                    q.offer(new Node(nr, nc, nValue, crush, nDayAndNight, true));
                    visited[nr][nc][crush] = true;
                } else { // 제자리가 아닌 경우
                    // 벽인 경우 K보다 적게 부수고, 방문 안했고, 낮인 경우
                    if(map[nr][nc] == 1 && crush < K && !visited[nr][nc][crush + 1] && dayAndNight) {
                        q.offer(new Node(nr, nc, nValue, crush + 1, nDayAndNight, false));
                        visited[nr][nc][crush + 1] = true;
                    }

                    // 이동 가능한 경우
                    if(map[nr][nc] == 0 && !visited[nr][nc][crush]) {
                        q.offer(new Node(nr, nc, nValue, crush, nDayAndNight, false));
                        visited[nr][nc][crush] = true;
                    }
                }

            }


        }


    }

    static boolean bc(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}