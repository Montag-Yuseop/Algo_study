import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // if(s.charAt(0) == '-') {
        //     s = s.substring(1);
        //     answer = Integer.parseInt(s);
        //     answer *= -1;
        // } else if(s.charAt(0) == '+') {
        //     s = s.substring(1);
        //     answer = Integer.parseInt(s);
        // } else {
        //     answer = Integer.parseInt(s);
        // }
        // answer = Integer.valueOf(s);
        
        return Integer.valueOf(s);
    }
}