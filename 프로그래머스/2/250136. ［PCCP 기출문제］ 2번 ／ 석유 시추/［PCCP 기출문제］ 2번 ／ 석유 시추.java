import java.util.*;

class Solution {
    static class Node{
        int r, c, value;
        
        public Node(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }
    
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[][] visited;
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        int M = land[0].length;
        int N = land.length;
        visited = new int[N][M];
        int idx = 1;
        
        // 시추관은 열에 맞게 뚫는다
        // 해당 열에서 아래로 내려가면서 석유가 있을 경우 BFS 탐색을 진행해보고, 석유의 양을 더한다
        // 가장 많은 경우를 답으로 입력하고 출력한다
        // 매번 탐색해야 하는가? 아니면 한 번만 탐색 한 뒤 값을 저장하고 출력할 수 있는가?
        // 우선은 열 기준으로 BFS를 쭉 돌리자 -> 시간초과
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(visited[r][c] == 0 && land[r][c] == 1) {
                    bfs(land, r, c, idx);
                    idx++;
                }
            }
        }    
        
        for(int c = 0; c < M; c++) {
            int temp = 0;
            boolean[] check = new boolean[idx+1];
            for(int r = 0; r < N; r++) {
                if(visited[r][c] > 0 && !check[visited[r][c]]) {
                    check[visited[r][c]] = true;
                    temp += map.get(visited[r][c]);
                }
            }
            answer = Math.max(answer, temp);
        }
        
        // for(int[] v : visited) {
        //     System.out.println(Arrays.toString(v));
        // }
        // System.out.println(map);
        
        return answer;
    }
    
    public void bfs(int[][] land, int startR, int startC, int idx) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startR, startC, 1));
        visited[startR][startC] = idx;
        int temp = 1;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;
            int nowValue = cur.value;
            
            for(int d = 0; d < 4; d++) {
                int nr = nowR + dr[d];
                int nc = nowC + dc[d];
                
                if(bc(nr, nc, land.length, land[0].length) && visited[nr][nc] == 0 && land[nr][nc] == 1) {
                    q.offer(new Node(nr, nc, nowValue+1));
                    temp++;
                    visited[nr][nc] = idx;
                }
                
            }
            
        }
        
        map.put(idx, temp);
    }
    
    
    public boolean bc(int r, int c, int N, int M) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}