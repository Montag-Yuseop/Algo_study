import java.util.*;

class Solution {
    
    // adj
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    static int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        
        for(int i = 0; i < info.length; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        
        boolean[] visited = new boolean[info.length];
        dfs(0, 0, 0, visited, info);
        
        return answer;
    }
    
    public static void dfs(int now, int sheep, int wolf, boolean[] visited, int[] info) {
        if(info[now] == 0) {
            sheep++;
        } else {
            wolf++;
        }
        
        if(wolf >= sheep) return;
        
        boolean[] newVisited = visited.clone();
        newVisited[now] = true;
        
        answer = Math.max(answer, sheep);
        
        for(int i = 0; i < adj.size(); i++) {
            if(newVisited[i]) {
                for(int x : adj.get(i)) {
                    if(!newVisited[x]) dfs(x, sheep, wolf, newVisited, info);
                }
                
            }
        }
        
        
        
    }
}