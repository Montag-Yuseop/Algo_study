import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int r, c, value;

        public Node(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    static int[][] map;

    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;
    static int N;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 너비 우선 탐색을 통해 섬을 모두 방문처리한다 - 섬마다 번호를 다르게 붙여준다
        int num = 1;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                // 섬에 번호를 붙여준다
                // 다만, 방문한 적이 있거나, 섬이 아닌 바다면 건너뛴다
                if(visited[r][c] || map[r][c] == 0) continue;
                createNum(r, c, num);
                num++;
            }
        }
        // 섬 전체를 처리 했으면, 새로운 탐색을 통해 다른 섬까지의 최단거리를 계산한다
        // 방문 배열을 초기화해서 자기 섬이 아닌 구역만 실행하도록 한다
        // 또한 바다는 건너뛴다
        visited = new boolean[N][N];
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(map[r][c] == 0 || visited[r][c]) continue;
                findIsland(r, c);
            }
        }

        System.out.println(answer);
    }
    static void findIsland(int r, int c) {
//        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        // 여기서만 사용할 새로운 방문 배열을 만든다(다음 섬으로 가는 길을 방문했는지 확인하기 위해)
        boolean[][] check = new boolean[N][N];
        visited[r][c] = true; // 원래 방문 배열도 처리
        int nowIsland = map[r][c]; // 현재 섬의 정보 저장
        q.offer(new Node(r, c, 0)); // 지금 노드의 value는 이동한 거리가 된다
        check[r][c] = true; // 방문처리

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;
            int cnt = cur.value;

            for(int d = 0; d < 4; d++) {
                int nextR = nowR + dr[d];
                int nextC = nowC + dc[d];
                int nextCnt = cnt + 1;

                if(bc(nextR, nextC) && !check[nextR][nextC]) {
                    if(map[nextR][nextC] > 0 && map[nextR][nextC] != nowIsland) {
                        // 바다가 아니면서, 다른 섬인 경우
                        answer = Math.min(answer, cnt);
                        return;
                    }

                    // 현재 섬과 동일하다면 방문 처리만 진행
                    if(map[nextR][nextC] == nowIsland) {
                        q.offer(new Node(nextR, nextC, cnt));
                        visited[nextR][nextC] = true;
                    }

                    if(map[nextR][nextC] == 0) {
                        // 0이라면 이동 거리를 1 증가한 뒤 q에 넣고 진행
                        q.offer(new Node(nextR, nextC, nextCnt));

                    }

                    check[nextR][nextC] = true;

                }

            }

        }

    }


    static void createNum(int r, int c, int num) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c, map[r][c]));
        map[r][c] = num;
        visited[r][c] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;

            for(int d = 0; d < 4; d++) {
                int nextR = nowR + dr[d];
                int nextC = nowC + dc[d];

                if(bc(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == 1) {
                    q.offer(new Node(nextR, nextC, map[nextR][nextC]));
                    visited[nextR][nextC] = true;
                    map[nextR][nextC] = num;
                }
            }
        }

    }

    static boolean bc(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

}