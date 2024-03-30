import java.util.*;

class Solution {
    
    static int answer;
    static boolean[] visited;
    
    public int solution(int[] nums) {
        answer = 0;
        visited = new boolean[nums.length]; // 방문 배열
        
        dfs(nums, 0, 0, 0); // 배열, sum, depth, idx

        return answer;
    }
    
    static void dfs(int[] nums, int sum, int depth, int idx) {
        if(depth >= 3) {
            if(isPrime(sum)) {
                answer++;
            }
            return;
        }
        
        for(int i = idx; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(nums, sum + nums[i], depth + 1, i+1);
                visited[i] = false;
            }
            
        }   
    }
    
    static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}