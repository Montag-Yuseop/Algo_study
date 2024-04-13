import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        
        String[] nara = {"4", "1", "2"};
        
        while(n > 0) {
            int value = n / 3;
            int r = n % 3;
            n = value;
            if(r == 0) n -= 1;
      
            answer = nara[r] + answer;
        }
        
        return answer;
    }
}