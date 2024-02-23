import java.util.*;

class Solution {
    
    static class Node {
        int r, c, cnt;
        
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    static boolean[][] visited;
    static int N, M, answer;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    
    
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        
        bfs(maps);
        
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
    
    static void bfs(int[][] maps) {
        Queue<Node> q = new LinkedList();
        q.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;
            int nowCnt = cur.cnt;
            
            if(nowR == N-1 && nowC == M-1) {
                answer = nowCnt;
                return;
            }
            
            for(int d = 0; d < 4; d++) {
                int nextR = nowR + dr[d];
                int nextC = nowC + dc[d];
                int nextCnt = nowCnt + 1;
                
                if(bc(nextR, nextC) && maps[nextR][nextC] == 1 && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    q.offer(new Node(nextR, nextC, nextCnt));
                }
                
            }
            
        }
    }
    
    static boolean bc(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    
}