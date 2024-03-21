import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zeroCnt = 0;        
        
        for(int i : lottos) {
            if(i == 0) {
                zeroCnt++;
                continue;
            }
            
            for(int j : win_nums) {
                if(i == j) cnt++;
            }
        }
        
        answer[1] = 7 - cnt;
        answer[0] = 7 - cnt - zeroCnt;
        if(cnt == 0) {
            answer[1] -= 1;
            if(zeroCnt == 0) {
                answer[0] -= 1;
            }
        }
        
        
        return answer;
    }
}