import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long y = Long.parseLong(p);
        
        for(int i = 0; i <= t.length() - p.length(); i++) {
            String s = "";
            for(int j = i; j < i + p.length(); j++) {
                s += t.charAt(j);
            }
            
            // 해당 숫자와 p를 비교
            long x = Long.parseLong(s);
            // System.out.println("x= "+x +" y= "+y);
            
            if(x <= y) answer++;
            
        }
        
        return answer;
    }
}