import java.util.*;

class Solution {
    
    static int n, m, answer, startR, startC;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static char[][] map;
    static int[][][] visited;
    
    static class Node {
        int r, c, isLever;
        
        public Node(int r, int c, int isLever) {
            this.r = r;
            this.c = c;
            this.isLever = isLever;
        }
    }
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        answer = -1;
        
        map = new char[n][m];
        visited = new int[n][m][2];
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                map[r][c] = maps[r].charAt(c);
                if(map[r][c] == 'S') {
                    startR = r;
                    startC = c;
                }
            }
        }
               
        bfs();

        return answer;
    }
    
    static void bfs() {
        Queue<Node> q = new LinkedList();
        q.offer(new Node(startR, startC, 0));
        visited[startR][startC][0] = 0;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;
            int nowIsLever = cur.isLever;
            if(nowIsLever == 1 && map[nowR][nowC] == 'E') {
                answer = visited[nowR][nowC][1];
                return;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = nowR + dr[d];
                int nc = nowC + dc[d];
                
                // 유효성 검사
                if(!bc(nr, nc) 
                   || visited[nr][nc][nowIsLever] != 0 
                   || map[nr][nc] == 'X') continue;

                if(nowIsLever == 0 && map[nr][nc] == 'L') {
                    q.offer(new Node(nr, nc, 1));
                    visited[nr][nc][1] = visited[nowR][nowC][0] + 1;
                } else {
                    q.offer(new Node(nr, nc, nowIsLever));
                    visited[nr][nc][nowIsLever] = visited[nowR][nowC][nowIsLever] + 1;
                }
                
                
            }
            
        }
        
        
    }
    
    static boolean bc(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < n && nc < m;
    }
}