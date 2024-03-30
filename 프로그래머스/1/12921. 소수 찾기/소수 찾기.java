import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        
        for(int i = 2; i <= n; i++) {
            for(int j = 2; i * j <= n; j++) {
                visited[i*j] = true;
            }
        }
        
        for(int i = 2; i <= n; i++) {
            if(!visited[i]) ++answer;
        }
        
        return answer;
    }
}