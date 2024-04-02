import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(String s : babbling) {
            if(s.contains("ayaaya") || 
              s.contains("yeye") ||
              s.contains("woowoo") ||
              s.contains("mama")) {
                continue;
            }
            
            s = s.replaceAll("aya", " ");
            s = s.replaceAll("ye", " ");
            s = s.replaceAll("woo", " ");
            s = s.replaceAll("ma", " ");
            s = s.replaceAll(" ", "");
            
            if(s.length() == 0) ++answer;
        }
        
        return answer;
    }
}