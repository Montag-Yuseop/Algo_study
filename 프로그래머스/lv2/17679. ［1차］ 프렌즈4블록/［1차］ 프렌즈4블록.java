import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    static class Node {
        int r, c;
        char name;
        
        public Node(int r, int c, char name){
            this.r = r;
            this.c = c;
            this.name = name;
        }
        
    }
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        char[][] copyMap = new char[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = board[i].charAt(j);
                copyMap[i][j] = board[i].charAt(j);
            }
        }
        boolean[][] visited = new boolean[m][n];
        int[] dr = {0, 1, 1};
        int[] dc = {1, 1, 0};
            
        Queue<Node> q = new LinkedList<>();
        
        
        while(true) {
        int temp = answer; // 종료 조건을 주기 위한 임시 변수
        visited = new boolean[m][n];
        visited[0][0] = true;       
        q.offer(new Node(0, 0, map[0][0])); // 시작 지점 q에 삽입
        
        // 파괴 조건 생성
        while(!q.isEmpty()){
            Node cur = q.poll();
            int nowR = cur.r;
            int nowC = cur.c;
            char item = cur.name;
            if(nowR == m-1 || nowC == n-1) {
                continue;               
            }
            
            boolean check = true;
            
            for(int d = 0; d < 3; d++){
                int nr = nowR + dr[d];
                int nc = nowC + dc[d];
                
                if(bc(nr, nc, m, n)){
                    if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc, map[nr][nc]));
                    }
                    if(item != map[nr][nc]){
                        check = false;
                    }
                }      
            }
            // 위의 검증을 통과했으면
            if(check) {
                if(copyMap[nowR][nowC] != '0'){
                    copyMap[nowR][nowC] = '0';    
                    answer++;
                }
                
                for(int nd = 0; nd < 3; nd++){
                    int nnr = nowR + dr[nd];
                    int nnc = nowC + dc[nd];
                        
                    if(bc(nnr, nnc, m, n) && copyMap[nnr][nnc] != '0') {
                        copyMap[nnr][nnc] = '0';
                        answer++;
                    }
                }                    
            } 
        }
 
            
        // 중력 조건 생성
        for(int c = 0; c < n; c++){
            for(int r = m-1; r >= 0; r--){
                if(copyMap[r][c] == '0'){
                    for(int k = r-1; k >= 0; k--){
                        if(copyMap[k][c] != '0'){
                            copyMap[r][c] = copyMap[k][c];
                            copyMap[k][c] = '0';
                            break;
                        }
                    }
                }
            }
        }
            
        // 맵을 copyMap으로 변경
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                map[r][c] = copyMap[r][c];
            }
        }    
        
    
        if(temp == answer) break; // 위의 조건식을 돌렸는데 temp가 안바뀌었다? 그럼 더 이상 파괴할 것이 없는 것
        }
        
        return answer;
    }
    
    public static boolean bc(int nr, int nc, int m, int n){
        return nr >= 0 && nc >= 0 && nr < m && nc < n;
    }
    
}