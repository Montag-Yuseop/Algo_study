import java.util.*;

class Solution {
    static String[] strArr = {"A", "E", "I", "O", "U"};
    static PriorityQueue<String> pq = new PriorityQueue<>();
    
    public int solution(String word) {
        
        
        
        for(int i = 0; i < 5; i++) {
            dfs(i, "");
        }
        
        int answer = 0;
        
        while(!pq.isEmpty()) {
            String s = pq.poll();
            ++answer;
            if(s.equals(word)) break;
        }
        
        return answer;
    }
    
    static void dfs(int i, String word) {
        if(word.length()-1 == i) {
            pq.offer(word);
            return;
        }
        
        for(int j = 0 ; j < 5; j++) {
            String sum = word + strArr[j];
            dfs(i, sum);
        }
        
    }
}