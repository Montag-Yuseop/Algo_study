import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static int N, M, answer;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[][] map, copyMap;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];

        // 맵 생성
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 빙하의 높이는 최대 10이므로 최대 10번 탐색하면 된다

        for(int i = 0; i < 1000; i++) {

            // 방문 배열을 초기화 해준다
            boolean[][] visited = new boolean[N][M];

            // 맵을 똑같이 복사한다
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    copyMap[r][c] = map[r][c];
                }
            }

            // 빙하의 수를 파악한다
            int many = 0;
            for(int r = 1; r < N - 1; r++) {
                for(int c = 1; c < M - 1; c++) {
                    // 방문한 적이 있거나, 0이면 진행하지 않는다
                    if(visited[r][c] || map[r][c] == 0) continue;
                    dfs(r, c, visited);
                    many++;
                }
            }

            if(many >= 2) {
                // 빙하 수가 두 개 이상으로 분리되면 answer를 걸린 시간으로 저장하고 종료한다(최초이기 때문)
                answer = i;
                break;
            } else {
                // 빙하가 한 덩어리 이하면 answer는 0으로 만들고 다시 진행한다.
                answer = 0;
            }

            // 빙하 수를 파악했으면 빙하를 녹이는 함수를 실행한다
            melt();

        }

        System.out.println(answer);
    }

    static void melt() {
        // 전체 복사된 맵을 순회하면서 원본 map 배열을 변경해준다
        for(int r = 1; r < N-1; r++) {
            for(int c = 1; c < M-1; c++) {
                int nowNum = copyMap[r][c];
                int isZero = 0;

                for(int d = 0; d < 4; d++) {
                    int nextR = r + dr[d];
                    int nextC = c + dc[d];

                    if(copyMap[nextR][nextC] == 0) {
                        isZero++;
                    }
                }

                map[r][c] = Math.max(nowNum - isZero, 0);
            }
        }

    }

    static void dfs(int r, int c, boolean[][] visited) {
        // map 배열을 활용해 깊이 우선 탐색을 진행한다
        visited[r][c] = true;

        for(int d = 0; d < 4; d++) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];

            if(!visited[nextR][nextC] && map[nextR][nextC] != 0) {
                dfs(nextR, nextC, visited);
            }


        }

    }


}