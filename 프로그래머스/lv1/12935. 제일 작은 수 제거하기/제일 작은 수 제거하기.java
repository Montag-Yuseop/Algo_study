import java.util.*;

class Solution {
    public int[] solution(int[] arr) {        
        if(arr.length == 1) {
            int[] answer = {-1};
            return answer;
        } else {
            int[] answer = new int[arr.length-1];
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length; i++) {
                min = Math.min(min, arr[i]);
            }
            
            int idx = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == min) continue;
                answer[idx++] = arr[i];
            }
            return answer;
            
        }
    
    }
}