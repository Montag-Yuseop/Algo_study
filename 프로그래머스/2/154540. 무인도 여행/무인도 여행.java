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
    
    static int[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {-1, 1, 0, 0};
    static int n, m;
    static boolean[][] visited;
    static ArrayList<Integer> list;
    
    public int[] solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        map = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            String s = maps[i];
            for(int j = 0; j < m; j++) {
                if(s.charAt(j) == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = s.charAt(j)-'0';  
                }
            }
        }
        
        visited = new boolean[n][m];
        list = new ArrayList();
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(!visited[r][c] && map[r][c] != 0)
                bfs(r, c);
            }
        }
        
        System.out.println(list);
        
        if(list.size() == 0) {
            int[] answer = {-1};
            return answer;
        }
        else {
            int[] answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
            return answer;
        }
    }
    
    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList();
        q.offer(new Node(r, c, map[r][c]));
        visited[r][c] = true;
        int sum = 0;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            sum += cur.cnt;
            // System.out.println(sum);
            
            for(int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if(bc(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0) {
                    q.offer(new Node(nr, nc, map[nr][nc]));
                    visited[nr][nc] = true;
                }
            }
            if(q.isEmpty()) list.add(sum);
        }
        

        
    }
    
    static boolean bc(int nr, int nc) {
        return (nr>=0 && nc >= 0 && nr < n && nc <m);
    }
}