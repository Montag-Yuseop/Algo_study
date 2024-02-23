import java.util.*;

class Solution {
    
    static class Node{
        int r, c, cnt;
        
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
        
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = Integer.MAX_VALUE;
        int[][] map = new int[101][101];
        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        // 사각형 좌표로 내용물 채우기
        for(int i = 0; i < rectangle.length; i++) {
            int r1 = Math.min(rectangle[i][1], rectangle[i][3]) * 2;
            int r2 = Math.max(rectangle[i][1], rectangle[i][3]) * 2;
            
            int c1 = Math.min(rectangle[i][0], rectangle[i][2]) * 2;
            int c2 = Math.max(rectangle[i][0], rectangle[i][2]) * 2;
            
            // System.out.println("r1: " + r1 + " r2: " + r2 + " c1: " + c1 + " c2:" + c2);
            
            for(int j = r1; j <= r2; j++) {
                for(int k = c1; k <= c2; k++) {
                    if(j == r1 || j == r2) {
                        if(map[j][k] != 2) map[j][k] = 1;
                    } else if(k == c1 || k == c2) {
                        if(map[j][k] != 2) map[j][k] = 1;
                    } else {
                        map[j][k] = 2;
                    }
                    
                }

            }
            
        }
        
        // 1인 곳만 지나갈 수 있게 설계
        // for(int i = 20; i >= 0; i--) {
        //     for(int j = 0; j < 20; j++) {
        //         System.out.print(map[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        
        boolean[][] visited = new boolean[101][101];
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};
        
        Queue<Node> q = new LinkedList();
        q.offer(new Node(characterY, characterX, 0));
        visited[characterY][characterX] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;
            int nowCnt = cur.cnt;
            
            if(nowR == itemY && nowC == itemX) {
                answer = nowCnt;
                return answer / 2;
            }
            
            for(int d = 0; d < 4; d++) {
                int nextR = nowR + dr[d];
                int nextC = nowC + dc[d];
                int nextCnt = nowCnt + 1;
                
                if(bc(nextR, nextC) && map[nextR][nextC] == 1 && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    q.offer(new Node(nextR, nextC, nextCnt));
                }
                
            }
            
        }
        
        return -1;
    }
    
    static boolean bc(int r, int c) {
        return r >= 0 && r <= 100 && c >= 0 && c <= 100;
    }
}