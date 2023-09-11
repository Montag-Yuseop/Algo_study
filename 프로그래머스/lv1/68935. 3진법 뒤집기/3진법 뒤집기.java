import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = "";
        
        while(n != 0) {
            s += String.valueOf(n%3);
            n = n / 3;
        }
        
        
        // for(int i = 0; i < s.length(); i++) {
        //     answer += Math.pow(3,i)*(s.charAt(s.length()-i-1)-'0');
        //     System.out.println(answer);
        // }
        
        answer = Integer.parseInt(s, 3);
        
        return answer;
    }
}