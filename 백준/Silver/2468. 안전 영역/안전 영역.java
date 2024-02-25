import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int N;

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static class Node {
        int r, c, value;

        public Node(int r, int c, int value){
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int answer = 0;
        map = new int[N][N];
        int max = 0;

        for(int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[r][c]);
            }
        }


        for(int i = 0; i <= max; i++) {
            int temp = 0;
            visited = new boolean[N][N];
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    if(!visited[r][c] && map[r][c] > i) {
//                        System.out.println("i = " + i + " r = " + r + " c = " +c);
                        bfs(r, c, i);
                        temp++;
                    }
                }
            }
//            System.out.println("i = " + i + " answer = " + answer +" temp = "+temp);
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }

    public static void bfs(int startR, int startC, int max) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startR, startC, map[startR][startC]));
        visited[startR][startC] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;

            for(int d = 0; d < 4; d++) {
                int nextR = nowR + dr[d];
                int nextC = nowC + dc[d];

                if(bc(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] > max) {
                    q.offer(new Node(nextR, nextC, map[nextR][nextC]));
                    visited[nextR][nextC] = true;
                }
            }
        }

    }

    static boolean bc(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}