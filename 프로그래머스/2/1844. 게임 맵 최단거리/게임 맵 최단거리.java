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
    static int answer = -1;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    
    public int solution(int[][] maps) {
        
        bfs(maps);
        
        return answer;
    }
    
    static void bfs(int[][] map) {
        Queue<Node> q = new LinkedList<>();
        int targetR = map.length - 1;
        int targetC = map[0].length - 1;
        boolean[][] visited = new boolean[targetR + 1][targetC + 1];
        
        q.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;
            int nowValue = cur.value;
            
            if(nowR == targetR && nowC == targetC) {
                answer = nowValue;
            }
            
            for(int d = 0; d < 4; d++) {
                int nextR = nowR + dr[d];
                int nextC = nowC + dc[d];
                
                if(bc(nextR, nextC, targetR + 1, targetC + 1) &&
                   map[nextR][nextC] == 1 && 
                   !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    q.offer(new Node(nextR, nextC, nowValue + 1));
                }
                
            }
            
        }
        
        
    }
    
    static boolean bc(int r, int c, int N, int M) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
    
}