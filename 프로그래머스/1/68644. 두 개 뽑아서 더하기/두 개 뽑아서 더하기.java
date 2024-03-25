import java.util.*;

class Solution {
    
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    
    public List<Integer> solution(int[] numbers) {
        
        visited = new boolean[numbers.length];
        
        dfs(numbers, 1, 0);
        List<Integer> answer = new ArrayList<>(set);
        
        Collections.sort(answer);
        
        
        return answer;
    }
    
    static void dfs(int[] numbers, int depth, int sum) {
        if(depth > 2) {
            set.add(sum);
            return;
        }
        
        for(int i = 0; i < numbers.length; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            dfs(numbers, depth + 1, sum + numbers[i]);
            visited[i] = false;
            
        }
        
    }
}