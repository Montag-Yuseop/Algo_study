import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c, value;

        public Node(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

    }

    static int N, M, P;

    static char[][] map;
    static boolean[][] visited;
    static int[] move, answer;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // 각 플레이어의 확장 범위
        move = new int[P + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= P; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        map = new char[N][M];
        visited = new boolean[N][M];
        answer = new int[P+1];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        bfs();
        for(int i = 1; i <= P; i++) {
            sb.append(answer[i]+ " ");
        }

        System.out.println(sb);

    }

    static void bfs() {
        Queue<Node>[] q = new Queue[P+1]; // q의 리스트 생성 -> 플레이어마다 큐를 만들어줘서 반복할 예정
        for(int i = 0; i <= P; i++) {
            q[i] = new LinkedList<>();
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    if(i == map[r][c] - '0') {
                        q[i].offer(new Node(r, c, move[i])); // 해당 좌표와 이동 범위를 저장
                        visited[r][c] = true;
                        answer[i]++;
                    }
                }
            }
        }
        int finish = 0;
        // 종료된 유저가 유저수가 될 때 반복문을 종료한다
        while(finish < P) {
            // 플레이어 수를 반복하며 돈다
            for(int i = 1; i <= P; i++) {
                if(q[i].isEmpty()) continue; // 해당 유저의 q가 비었으면 건너뛰고

                int moveValue = move[i]; // 그걸 해당 유저의 이동 가능 범위만큼 반복해준다

                for(int m = 1; m <= move[i]; m++) { // 1부터 이동 범위만큼 반복하며
                    int qSize = q[i].size(); // 지금 있는 qSize만큼 돌자
                    int check = 0;
                    for(int t = 1; t <= qSize; t++) {
                        if(q[i].isEmpty()) continue;
                        Node cur = q[i].poll();
                        int nowR = cur.r;
                        int nowC = cur.c;

                        for(int d = 0; d < 4; d++) {
                            int nextR = nowR + dr[d];
                            int nextC = nowC + dc[d];

                            if(bc(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == '.') {
                                visited[nextR][nextC] = true; // 방문처리
                                q[i].offer(new Node(nextR, nextC, moveValue)); // q에 새로 넣어준다
                                map[nextR][nextC] = (char) (i + '0');
                                answer[i]++;
                                check++;
                            }
                        }
                    }
                    if(check <= 0) break;

                }

                // 이동을 끝냈는데 q가 비어있다?(더 이상 확장 가능한 노드가 없다?)
                if(q[i].isEmpty()) finish++; // 종료 유저 수를 늘려준다
            }
        }
    }

    static boolean bc(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}