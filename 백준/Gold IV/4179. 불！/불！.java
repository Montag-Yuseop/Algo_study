import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int r, c, time;

        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int N, M;
    static Character[][] map;
    static int[][] fire, move;

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Character[N][M];
        fire = new int[N][M];
        move = new int[N][M];

        int jihunR = 0;
        int jihunC = 0;

        // 맵 생성
        for(int r = 0; r < N; r++) {
            String s = br.readLine();
            for(int c = 0; c < M; c++) {
                char ch = s.charAt(c);
                map[r][c] = ch;

                if(ch == '#') {
                    fire[r][c] = -1;
                    move[r][c] = -1;
                }

                if(ch == 'J') {
                    jihunR = r;
                    jihunC = c;
                }
            }
        }
        // 불이 나는걸 BFS로 진행하면서 몇 분인지 적는다. 불은 여러곳에서 날 수 있다
//        for(int r = 0; r < N; r++) {
//            for(int c = 0; c < M; c++) {
//                // 배열을 탐색하면서 불이 난 지역
//            }
//        }

        fireBfs();

        // 적은 분과 지훈이가 이동하는 분을 비교해서 지훈이 이동 분이 더 낮으면 이동 한다
        // 더 높거나 같으면 -1로 이동 불가 처리를 한다.
        // 벽 끝에 닿으면 탈출이 가능하므로 해당 분을 출력한다.

        int answer = moving(jihunR, jihunC);

//        for(int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(fire[i]));
//        }

        if(answer == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);
    }

    public static int moving(int startR, int startC) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startR, startC, 1));
        move[startR][startC] = 1;

        // 지훈이 값을 입력해 준 다음 BFS 탐색
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;
            int nowTime = cur.time;

            // 종료 조건
            if(nowR == 0 || nowR == N - 1 || nowC == 0 || nowC == M - 1) {
                return nowTime;
            }

            // 사방 탐색 진행
            for(int d = 0; d < 4; d++) {
                int nextR = nowR + dr[d];
                int nextC = nowC + dc[d];
                int nextTime = nowTime + 1;

                // 좌표 값이 벗어나지 않고, fire의 값보다 nowTime+1 값이 더 낮고, 방문한 적이 없는 경우 진행
                if(bc(nextR, nextC) && nextTime < fire[nextR][nextC] && move[nextR][nextC] == 0) {
                    q.offer(new Node(nextR, nextC, nextTime));
                    move[nextR][nextC] = nextTime;
                }
            }

        }

        return -1;
    }

    public static void fireBfs() {
        Queue<Node> q = new LinkedList<>();
        // 불이 난 곳을 먼저 다 큐에 넣어주면 되지 않을까?
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(map[r][c] == 'F') {
                    fire[r][c] = 1;
                    q.offer(new Node(r, c, 1));
                }
            }
        }

        // 큐에 전부 넣은 다음 BFS 탐색을 진행하자
        while(!q.isEmpty()) {
            Node cur = q.poll(); // 현재 노드를 뽑는다
            int nowR = cur.r;
            int nowC = cur.c;
            int nowTime = cur.time;

            // 사방탐색을 진행한다
            for(int d = 0; d < 4; d++) {
                int nextR = nowR + dr[d];
                int nextC = nowC + dc[d];

                // 다음 좌표가 배열 내일 경우 and -1이 아닐 경우 and 방문을 안한 경우 진행
                if(bc(nextR, nextC) && fire[nextR][nextC] == 0) {
                    fire[nextR][nextC] = nowTime + 1;
                    q.offer(new Node(nextR, nextC, nowTime + 1));
                }
            }

        }

        // 다 돌았으면 불이 못 간 곳은 최댓값처리
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(fire[r][c] == 0) fire[r][c] = Integer.MAX_VALUE;
            }
        }

    }

    public static boolean bc(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

}