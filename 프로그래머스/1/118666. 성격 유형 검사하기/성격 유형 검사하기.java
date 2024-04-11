import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        int N = survey.length;
        
        Map<Character, Integer> map = new HashMap<>();
        
        // survey 돌기
        for(int i = 0; i < N; i++) {
            int score = choices[i];
            
            // 비동의
            char c1 = survey[i].charAt(0);
            
            // 동의
            char c2 = survey[i].charAt(1);
            
            if(score < 4) {
                map.put(c1, map.getOrDefault(c1, 0) + Math.abs(score - 4));
            } else if(score > 4) {
                map.put(c2, map.getOrDefault(c2, 0) + Math.abs(score - 4));
            }
            
        }
        
        sb
            .append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T')
            .append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F')
            .append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M')
            .append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');
        
        return sb.toString();
    }
}