import java.util.*;

class Solution {
    
    static int answer;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visited = new boolean[dungeons.length];
        
        // dfs를 통해 노드 위치의 던전을 탐색해본다.
        // 해당 던전을 탐색할 수 있으면 cnt를 넘겨서 몇 개의 던전을 돌았는지 저장한다
        // 더 이상 돌 수 없으면 해당 던전 돈 횟수와 answer 중 큰 것을 돈다
        
        // 남은 피로도, 던전, 돈 횟수, depth(최대 던전 개수만큼 돌 수 있음)
        dfs(k, dungeons, 0, 0);
        
        return answer;
    }
    
    static void dfs(int k, int[][] dungeons, int cnt, int depth) {
        answer = Math.max(answer, cnt);
        
        // 더 이상 돌 던전이 없으면
        if(depth > dungeons.length) {
            
            return;
        }
        
        
        // 던전을 돌 수 있으면
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i]) { // 방문하지 않은 던전을 돌며
                // 현재 피로도가 필요 피로도 이하인 경우 
                if(k < dungeons[i][0]) {
                    answer = Math.max(answer, cnt);
                } else {
                    visited[i] = true;
                    dfs(k - dungeons[i][1], dungeons, cnt+1, depth+1);
                    visited[i] = false;
                }
                
                
                
            }
            
        }
        
        
    }
}