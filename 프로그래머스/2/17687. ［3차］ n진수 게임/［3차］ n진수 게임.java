import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String s = "";
        // int num = 0;
        
//         while(answer.length() <= t) {
            
//         }
        
        // 숫자 만들기
        for(int i = 0; i <= t * m; i++) {
            s += Integer.toString(i, n);
        }
        
        // s 돌면서 나머지 인덱스 answer에 추가
        for(int i = p-1; answer.length() < t; i+=m) {
            answer += (s.charAt(i) + "");
        }
        
        return answer.toUpperCase();
    }
}