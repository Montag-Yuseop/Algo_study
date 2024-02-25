import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int l, r, c, time;

        public Node(int l, int r, int c, int time) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int L, R, C;
    static StringBuilder sb = new StringBuilder();
    static char[][][] map;
    static boolean[][][] visited;

    // 4번 5번 인덱스는 아래위로 이동
    static int[] dr = {0, 0, -1, 1, 0, 0}; // 상하좌우
    static int[] dc = {-1, 1, 0, 0, 0, 0}; // 상하좌우 이동

    static int[] dl = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0) break;

            map = new char[L][R][C];
            visited = new boolean[L][R][C];
            int startL = -1;
            int startR = -1;
            int startC = -1;

            // 맵 입력
            for(int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String s = br.readLine();
                    for (int c = 0; c < C; c++) {
                        map[l][r][c] = s.charAt(c);
                        if(map[l][r][c] == 'S') {
                            startL = l;
                            startR = r;
                            startC = c;
                        }
                    }
                }
                String pass = br.readLine(); // 마지막 줄 띄어쓰기 처리
            }
            bfs(startL, startR, startC);
        }

        System.out.println(sb);
    }

    static void bfs(int startL, int startR, int startC) {
        Queue<Node> q = new LinkedList<>();
        visited[startL][startR][startC] = true;
        q.offer(new Node(startL, startR, startC, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowL = cur.l;
            int nowR = cur.r;
            int nowC = cur.c;
            int nowTime = cur.time;

//            System.out.println("nowL = " + nowL + " nowR = " + nowR +" nowC = " + nowC);

            if(map[nowL][nowR][nowC] == 'E') {
                sb.append("Escaped in ").append(nowTime).append(" minute(s).").append("\n");
                return;
            }

            for(int d = 0; d < 6; d++) {
                    int nextR = nowR + dr[d];
                    int nextC = nowC + dc[d];
                    int nextL = nowL + dl[d];
//                    System.out.println("nextL = " + nextL + " nextR = " + nextR +" nextC = " + nextC);

                    if(bc(nextL, nextR, nextC) && !visited[nextL][nextR][nextC] && map[nextL][nextR][nextC] != '#') {
                        visited[nextL][nextR][nextC] = true;
                        q.offer(new Node(nextL, nextR, nextC, nowTime + 1));
                    }
            }

        }

        sb.append("Trapped!").append("\n");

    }


    static boolean bc(int l, int r, int c) {
        return l >= 0 && l < L &&  r >= 0 && c >= 0 && r < R && c < C;
    }
}