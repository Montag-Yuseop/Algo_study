import java.util.*;

class Solution {
    public List<String> solution(String[] strings, int n) {
        
        List<String> answer = Arrays.asList(strings);
        Collections.sort(answer);
        Collections.sort(answer, (String a, String b) -> 
                        a.charAt(n) - b.charAt(n));
        
        
        return answer;
    }
}