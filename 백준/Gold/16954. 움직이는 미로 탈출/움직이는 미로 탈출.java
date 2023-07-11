import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // 움직이는 미로 탈출
    // 8X8의 체스판
    // 체스판은 .의 빈칸 또는 #의 벽
    // 욱제는 왼쪽 맨 아래(7,0)에서 시작
    // 0,7로 이동해야 함
    // 근데 욱제는 1초마다 8방이동 가능 + 현재 위치까지 가능(9방)
    // 벽은 1초마다 아래로 한 칸씩 밀려 내려옴
    // 맨 밑에 행에 있으면 벽은 사라짐
    // 욱제가 먼저 이동하고 다음 벽이 내려온다

    // 델타 배열 생성
    static int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static char[][] map;
    static boolean isOk;

    static boolean[][] visited;

    static class Node {
        int r, c;
        char[][] arr;

        public Node(int r, int c, char[][] arr) {
            this.r = r;
            this.c = c;
            this.arr = arr;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵 생성
        map = new char[8][8];
        for(int r = 0; r < 8; r++) {
            String s = br.readLine();
            for(int c = 0; c < 8; c++) {
                map[r][c] = s.charAt(c);
            }
        }
        visited = new boolean[8][8];

        isOk = false;
        // BFS 탐색
        // 근데 이동 한 번 할 때마다 맵이 아래로 내려와야 한다
        bfs();


        if(isOk) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(7, 0, map));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;

            if(nowR == 0 && nowC == 7) {
                isOk = true;
                return;
            }
            char[][] nowArr = cur.arr;
            char[][] nextArr = down(nowArr);
            for(int d = 0; d < 9; d++) {
                int nextR = nowR+dr[d];
                int nextC = nowC+dc[d];
                // 빈 칸으로만 이동이 가능하다

                // 제자리일 경우
                if(dr[d] == 0 && dc[d] == 0) {
                    if(bc(nextR, nextC) && nextArr[nextR][nextC] == '.') q.offer(new Node(nextR, nextC, nextArr));
                }

                else if(bc(nextR, nextC) && !visited[nextR][nextC] && nowArr[nextR][nextC] == '.') {
                    // 이동하고 다음 내려온 배열과 비교한다
                    // 그래서 다음 이동한 배열이 벽이라면, 이동이 불가능하다

                    if(nextArr[nextR][nextC] == '.') {
                        visited[nextR][nextC] = true;
                        q.offer(new Node(nextR, nextC, nextArr));
                    }
                }
            }
        }
    }

    public static boolean bc(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < 8 && nc < 8;
    }


    public static char[][] down(char[][] arr) {
        char[][] temp = new char[8][8];

        for(int r = 7; r > 0; r--) {
            for(int c = 0; c < 8; c++) {
                temp[r][c] = arr[r-1][c];
            }
        }
        for(int i = 0; i < 8; i++) {
            temp[0][i] = '.';
        }
        return temp;

    }

}