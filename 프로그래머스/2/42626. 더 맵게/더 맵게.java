import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int i : scoville) {
            pq.offer(i);
        }
                
        // print
        // System.out.println(pq);
        
        while(true) {
            int x = pq.poll();
            
            if(x >= K) {
                break;
            }
            
            if(x < K) {
                if(pq.isEmpty()) {
                    answer = -1;
                    break;
                }
                
                answer++;
                int y = pq.poll();
                pq.offer(x+2*y);
            }
                        
        }
        
        return answer;
    }
}