import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        answer = 0;
        visited = new boolean[numbers.length()];
        
        dfs(numbers, "", 0);
        
        for(int i : set) {
            if(i > 1) {
                if(isPrime(i)) answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isPrime(int num) {
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
    
    static void dfs(String numbers, String data, int depth) {
        if(data != "")set.add(Integer.parseInt(data));
        
        if(depth >= numbers.length()) {
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(numbers, data + numbers.charAt(i), depth + 1);
                visited[i] = false;
            } 
        }
    }
    
    
    
}