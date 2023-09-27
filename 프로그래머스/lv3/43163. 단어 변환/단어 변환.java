import java.util.*;

class Solution {
    
    public static int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        
        // 단어가 있는지 여부 우선 검토
        boolean check = false;
        for(String s : words) {
            if(s.equals(target)) check = true;
        }
        if(!check) return 0;
        int cnt = 0;
        boolean[] visited = new boolean[words.length];
        // 단어가 words 내에 포함되어 있는 경우
        // 현재 단어
        
        
        dfs(begin, target, cnt, words, visited);
        
        return answer;
    }
    
    static void dfs(String begin, String target, int cnt, String[] words, boolean[] visited) {
        if(begin.equals(target)) answer = Math.min(cnt, answer);
        
        if(cnt >= words.length) return;
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(begin)) continue;
            int temp = 0;
            for(int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) temp++;
            }
            
            if(temp < begin.length()-1) continue;
            if(!visited[i]) {
                visited[i] = true;
                dfs(words[i], target, cnt+1, words, visited);
                visited[i] = false; 
            }
            
        }
    }
}