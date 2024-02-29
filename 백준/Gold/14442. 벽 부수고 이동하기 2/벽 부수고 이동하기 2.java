import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int r, c, value, crush;

        public Node(int r, int c, int value, int crush) {
            this.r = r;
            this.c = c;
            this.value = value;
            this.crush = crush;
        }
    }

    static int N, M, K, answer;
    static int[][] map;

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][K + 1];
        answer = -1;

        // 맵 생성
        for(int r = 0; r < N; r++) {
            String s = br.readLine();
            for(int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c) - '0';
            }
        }

        // 미로 탐색
        bfs();

        System.out.println(answer);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0)); // 0, 0 Node 삽입, 거리는 자기 자신 포함 1부터 시작
        visited[0][0][0] = true; // 벽을 하나도 부수지 않은 상태의 시작 지점 방문처리

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;
            int value = cur.value;
            int nowCrush = cur.crush;

            // 목표 위치에 도달했다면
            if(nowR == N-1 && nowC == M - 1) {
                answer = value;
                return;
            }

            for(int d = 0; d < 4; d++) {
                int nextR = nowR + dr[d];
                int nextC = nowC + dc[d];

                // 범위를 벗어나면 건너 뛰기
                if(!bc(nextR, nextC)) continue;

                // 범위 내인 경우 다음 지역이 이동 가능이면 다음 위치로 진행
                if(!visited[nextR][nextC][nowCrush] && map[nextR][nextC] == 0) {
                    q.offer(new Node(nextR, nextC, value + 1, nowCrush));
                    visited[nextR][nextC][nowCrush] = true; // 방문 처리
                }

                // 다음 지역이 이동 불가능인 경우, 아직 crush를 K만큼 진행하지 않았다면?
                if(map[nextR][nextC] == 1 && nowCrush < K && !visited[nextR][nextC][nowCrush + 1]) {
                    q.offer(new Node(nextR, nextC, value + 1, nowCrush + 1));
                    visited[nextR][nextC][nowCrush + 1] = true;
                }



            }


        }

    }

    static boolean bc(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}