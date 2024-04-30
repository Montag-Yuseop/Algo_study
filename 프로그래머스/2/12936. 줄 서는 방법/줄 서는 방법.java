import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> list = new ArrayList<>();
        
        long f = 1;
        int idx = 0;
        
        for(int i = 1; i <= n; i++) {
            list.add(i);
            f *= i;
        }
        
        k--;
        
        while(n > 0) {
            f /= n;
            int v = (int) (k / f);
            answer[idx++] = list.get(v);
            list.remove(v);
            
            k %= f;
            n--;
        }
        
        
        return answer;
    }
    
    
}