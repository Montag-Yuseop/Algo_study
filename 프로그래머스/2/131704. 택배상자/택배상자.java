import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        
        Stack<Integer> sub = new Stack();
    
        for(int i = 1; i <= order.length; i++) {
            if(order[idx] != i) {
                sub.push(i);
            } else {
                ++idx;
                ++answer;
            }
            
            while(!sub.isEmpty() && sub.peek() == order[idx]) {
                sub.pop();
                ++idx;
                ++answer;
            }
        }
            
        return answer;
    }
}