import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minQ = new PriorityQueue();
        
        PriorityQueue<Integer> maxQ = new PriorityQueue(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String first = st.nextToken();
            String last = st.nextToken();
            
            if(first.equals("I")) {
                minQ.offer(Integer.parseInt(last));
                maxQ.offer(Integer.parseInt(last));
            } else {
                if(last.equals("1")) {
                    if(maxQ.isEmpty()) continue;
                    minQ.remove(maxQ.poll());
                } else {
                    if(minQ.isEmpty()) continue;
                    maxQ.remove(minQ.poll());
                }
            }
            
            if(maxQ.isEmpty()) answer[0] = 0;
            else {
                answer[0] = maxQ.peek();
            }
            if(minQ.isEmpty()) answer[1] = 0;
            else {
                answer[1] = minQ.peek();
            }
            
            
        }
        
        return answer;
    }
}