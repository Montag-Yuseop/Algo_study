import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // n을 k진수로 변경
        String s = Integer.toString(n,k);
        
        // 0을 기준으로 분리
        for(String i : s.split("0")) {
            if(i.equals("")) continue; // 비면 continue
            // System.out.println(i); // 분리 테스트
            if(isPrime(i)) answer++;
            
        }
        
        return answer;
    }
    
    static boolean isPrime(String num) {
        long now = Long.parseLong(num);
        if(now == 1) return false;
        
        for(int i = 2; i <= Math.sqrt(now); i++) {
            if(now % i == 0) return false;
        }
        
        
        return true;
    }
}