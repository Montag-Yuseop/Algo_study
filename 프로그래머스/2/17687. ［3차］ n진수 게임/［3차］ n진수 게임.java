import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        // StringBuilder 속도가 월등히 빠르다
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        // 숫자 만들기
        for(int i = 0; i <= t * m; i++) {
            sb.append(Integer.toString(i, n));
        }
        
        // s 돌면서 나머지 인덱스 answer에 추가
        for(int i = p-1; answer.length() < t; i+=m) {
            answer.append(sb.charAt(i));
        }
        
        return answer.toString().toUpperCase();
    }
}