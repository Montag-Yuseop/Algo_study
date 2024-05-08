import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        
        Arrays.sort(array);
        boolean check = false;
        for(int i : array) {
            if(i == n) {
                answer++;
                check = true;
            }
            
            if(check && i != n) break;
        }
        
        return answer;
    }
}