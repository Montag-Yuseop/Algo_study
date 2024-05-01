import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0; // 큰 값의 index를 저장할 변수
        
        for(int i = 0; i < number.length() - k; i++) {
            char max = 0;
            for(int j = idx; j <= i + k; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
                
                if(max == '9') break;
                
            }
            
            sb.append(max);
        }
        
        
        return sb.toString();
    }
}