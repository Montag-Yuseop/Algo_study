import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int N = ingredient.length;
        
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < N; i++) {
            stk.push(ingredient[i]);
            
            if(stk.size() > 3) {
                if(stk.get(stk.size()-4) == 1
                  && stk.get(stk.size()-3) == 2
                  && stk.get(stk.size()-2) == 3
                  && stk.get(stk.size()-1) == 1) {
                    
                    answer++;
                    for(int d = 0; d < 4; d++) {
                        stk.pop();
                    }
                    
                }
                
            }
        }

        return answer;
    }
}