import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char start = s.charAt(0);
        
        int[] count = {1, 0};
        boolean isOk = false;
        
        for(int i = 1; i < s.length(); i++) {
            if(isOk) {
                isOk = false;
                start = s.charAt(i);
                if(!isOk && i == s.length()-1) {
                    answer++;
                }
                continue;
            }
            
            char c = s.charAt(i);
            
            // 같으면 0번 인덱스를 증가
            if(start == c) {
                count[0]++;
            } else {
                // 다르면 1번 인덱스를 증가
                count[1]++;
                
                // 두 개의 숫자가 같아지면
                if(count[0] == count[1]) {
                    isOk = true;
                    count[0] = 1;
                    count[1] = 0;
                    answer++;
                }
            }
            
            if(i == s.length()-1) {
                if(!isOk) {
                    answer++;
                }
            }
            
            
        }
        
        if(answer == 0) answer = 1;
        return answer;
    }
}