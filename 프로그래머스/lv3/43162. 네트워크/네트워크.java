import java.util.*;

class Solution {
    
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 인접 리스트 초기화
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        // 인접 리스트 입력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                
                if(computers[i][j] == 1) {
                    adj.get(i).add(j);
                } 
            }
        }
        
        // 방문 배열
        visited = new boolean[n];
        
        // dfs 순회
        for(int i = 0; i < n; i++) {
            if(!visited[i]) { // 방문하지 않은 녀석
                dfs(i);
                answer++;
            }
            
        }
    
        
        return answer;
    }
    
    public static void dfs(int now) {
        // if(visited[now]) return;
        
        visited[now] = true;
        
        for(int i : adj.get(now)) {
            if(!visited[i]){
                dfs(i);
            }
        }
        
        
    }
}