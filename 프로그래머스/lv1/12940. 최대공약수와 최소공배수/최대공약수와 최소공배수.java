import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int min = Math.min(n, m);
        int x = 0;
        
        for(int i = 1; i <= min; i++) {
            if(n % i == 0 && m % i == 0) {
                x = Math.max(x, i);
            }
        }
        answer[0] = x;
        answer[1] = (n * m) / x;
        
        
        return answer;
    }
}