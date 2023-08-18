import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        
        int[] arr = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) -'0';
        }
        
        Arrays.sort(arr);
        s = "";
        for(int i = arr.length - 1; i >= 0; i--){
            s += String.valueOf(arr[i]);
        }
        
        answer = Long.parseLong(s);
        
        return answer;
    }
}