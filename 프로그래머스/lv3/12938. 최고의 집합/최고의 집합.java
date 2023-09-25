import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        
        // 각 원소의 합이 s가 되는 집합
        int temp = s / n;
        int rest = s % n;
        if(temp <= 0) return new int[] {-1};
        
        answer = new int[n];
        
        Arrays.fill(answer, temp);
        
        for(int i = 0; i < n; i++) {
            if(rest > 0) {
                answer[i]++;
                rest--;    
            }
            
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}