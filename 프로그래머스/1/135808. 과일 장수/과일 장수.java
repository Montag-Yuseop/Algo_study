import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int idx = score.length-1;
        while(true) {
            idx = idx - m + 1;
            if(idx < 0) break;
            
            answer += (score[idx] * m);
            idx -= 1;
        }  
        
        return answer;
    }
}