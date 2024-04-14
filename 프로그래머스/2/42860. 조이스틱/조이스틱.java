import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        
        // 알파벳을 찾는 숫자부터 카운트
        for(int i = 0; i < name.length(); i++) {
            char now = name.charAt(i);
            answer += Math.min(now - 'A', 'Z' - now + 1);
            
            // 좌우 이동 카운트
            // 만약 JAAAJAA면? 2번
            // 만약 JXAAAAJ면? 3번
            int nowIdx = i+1;
            while(nowIdx < name.length() && name.charAt(nowIdx) == 'A') {
                nowIdx++;
            }
            
            move = Math.min(move, (i * 2) + name.length() - nowIdx);
            move = Math.min(move, (name.length() - nowIdx) * 2 + i);
        }
        answer += move;
        
        
        return answer;
    }
}