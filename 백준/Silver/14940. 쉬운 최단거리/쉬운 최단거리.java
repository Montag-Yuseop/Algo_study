import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int r, c, w;
        public Node(int r, int c, int w){
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }
    static int[][] map; // 처음 입력 받을 맵
    static int N, M; // R, C의 크기
    static boolean[][] visited; // 방문 배열, 나중에 방문처리 안된 곳은 -1처리
    static int[] dr = {0, 0, -1, 1}; // 델타배열 d
    static int[] dc = {-1, 1, 0, 0}; // 델타배열 d 좌 우 상 하
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        // 처음 기준 시작 위치를 넣어주기
        int startR = 0, startC = 0;

        // 맵 생성
        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++){
                int x = Integer.parseInt(st.nextToken());
                map[r][c] = x;
                if(x == 2){
                    startR = r;
                    startC = c;
                }
                if(x == 0){
                    visited[r][c] = true;
                }
            }
        }
        // 시작 위치를 담아서 bfs 돌리기
        bfs(startR, startC);
        System.out.println(sb);
    }

    private static void bfs(int r, int c) {
        int[][] copy = new int[N][M];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c, 0));
        visited[r][c] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            // 사방탐색 시작
            for(int i = 0; i < 4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                // 경곗값을 통과한다면, 방문처리 후, 새로운 배열에 새로운 값을 넣기
                if(bc(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0){
                    visited[nr][nc] = true;
                    copy[nr][nc] = cur.w+1;
                    q.offer(new Node(nr, nc, cur.w+1));
                }
            }
        }

        // 방문 못 한 곳은 -1처리
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]){
                    sb.append(-1+" ");
                } else {
                    sb.append(copy[i][j]+" ");
                }
            }
            sb.append("\n");
        }
    }

    private static boolean bc(int nr, int nc) {
        return nr>=0 && nc>= 0 && nr<N && nc<M;
    }


}