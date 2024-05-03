import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int cnt = 1;
        
        for(int i = 1; i <= s.length()/2; i++) {
            StringBuilder sb = new StringBuilder();
            String str = s.substring(0, i); // 비교할 문자열
            for(int j = i; j <= s.length(); j+=i) { // i길이만큼 잘라서 봐야함
                int end = Math.min(j+i, s.length());
                String compare = s.substring(j, end);
                if(str.equals(compare)) {
                    cnt++;
                } else {
                    if(cnt >= 2) {
                        sb.append(cnt);
                    }
                    sb.append(str);
                    str = compare;
                    cnt = 1;
                }
                
            }
            sb.append(str);
            answer = Math.min(answer, sb.length());
        }
        
        
        return answer;
    }
}