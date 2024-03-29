import java.util.*;
import java.time.*;

class Solution {
    public String solution(int a, int b) {
        
        LocalDateTime d = LocalDateTime.of(2016, a, b, 0, 0);
        String answer = d.getDayOfWeek().toString().substring(0,3);
        
        
        return answer;
    }
}