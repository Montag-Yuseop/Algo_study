import java.util.*;

class Solution {
    static class Node {
        int time, value;
        
        public Node(int time, int value) {
            
            this.time = time;
            this.value = value;
            
        }
        
    }
    
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Node> stack = new Stack();
        
        // 스택 문제?
        
        for(int i = 0; i < prices.length; i++) {
            if(stack.isEmpty() || stack.peek().value <= prices[i]) {
                stack.add(new Node(i, prices[i])); // 스택이 비어있거나
            } else {
                Node cur = stack.pop();
                answer[cur.time] = i - cur.time;
                while(!stack.isEmpty() && stack.peek().value > prices[i]) {
                    cur = stack.pop();
                    answer[cur.time] = i - cur.time;
                }
                stack.add(new Node(i, prices[i]));
            }

        }
        
        while(!stack.isEmpty()) {
            Node cur = stack.pop();     
            answer[cur.time] = prices.length - cur.time-1;
            
        }
        
                
        return answer;
    }
}