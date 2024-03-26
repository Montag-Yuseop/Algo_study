import java.util.*;

class Solution {

    static class Node {
        int r, c, value;

        public Node(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    static boolean[][] visited;
    static int[][] map;
    static int maxCnt;

    public int[] solution(int m, int n, int[][] picture) {    
        visited = new boolean[picture.length][picture[0].length];

        int[] answer = new int[2];
        maxCnt = 0;

        map = new int[picture.length][picture[0].length];

        for(int r = 0; r < map.length; r++) {
            for(int c = 0; c < map[0].length; c++) {
                map[r][c] = picture[r][c]; 
            }
        }


        int v = 0;
        for(int r = 0; r < picture.length; r++) {
            for(int c = 0; c < picture[0].length; c++) {
                if(!visited[r][c] && map[r][c] != 0) {
                    bfs(r, c);
                    v++;
                }
            }
        }
        answer[0] = v;
        answer[1] = maxCnt;

        return answer;
    }

    static void bfs(int startR, int startC) {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        Queue<Node> q = new LinkedList<>();
        visited[startR][startC] = true;
        q.offer(new Node(startR, startC, map[startR][startC]));
        int cnt = 1;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int value = cur.value;

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(bc(nr, nc) && !visited[nr][nc] && map[nr][nc] == value) {
                    cnt++;
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc, map[nr][nc]));
                }
            }

        }
        maxCnt = Math.max(maxCnt, cnt);
    }

    static boolean bc(int r, int c) {
        int N = map.length;
        int M = map[0].length;
        return r >= 0 && c >= 0 && r < N && c < M;
    }

}