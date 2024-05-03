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
    
    static int startR = 0, startC = 0, endR = 0, endC = 0;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    
    public int solution(String[] board) {
        int answer = 0;
        
        char[][] map = new char[board.length][board[0].length()];
        
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length(); c++) {
                map[r][c] = board[r].charAt(c);
                if(map[r][c] == 'R') {
                    startR = r;
                    startC = c;
                }
                if(map[r][c] == 'G') {
                    endR = r;
                    endC = c;
                }
            }
        }
        
        answer = bfs(map);
        
        return answer;
    }
    
    static int bfs(char[][] map) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[startR][startC] = true;
        q.offer(new Node(startR, startC, 0));

        // q가 비지 않을 때 까지 진행
        while(!q.isEmpty()) {
            // 현 위치
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;
            int nowCnt = cur.cnt;
            
            if(map[nowR][nowC] == 'G') {
                return nowCnt;
            }
            
            // 사방 탐색 진행
            for(int d = 0; d < 4; d++) {
                // 사방으로 진행하면서, 벽에 닿거나, 장애물에 닿기 전까지 진행
                int nextR = nowR + dr[d];
                int nextC = nowC + dc[d];
                while(bc(nextR, nextC, map.length, map[0].length) && map[nextR][nextC] != 'D') {
                    nextR += dr[d];
                    nextC += dc[d];
                }
                
                nextR -= dr[d];
                nextC -= dc[d];
                
                if(!visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    q.offer(new Node(nextR, nextC, nowCnt + 1));
                }
            }
            
        }
        
        return -1;
    }
    
    static boolean bc(int r, int c, int N, int M) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}