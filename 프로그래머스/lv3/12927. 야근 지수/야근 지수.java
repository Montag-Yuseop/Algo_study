import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : works) {
            pq.offer(i);
        }
        
        for(int i = 0; i < n; i++) {
            int x = pq.poll();
            if(x == 0) return 0;
            
            pq.offer(x-1);
        }
        
        int size = pq.size();
        
        for(int i = 0; i < size; i++) {
            answer += Math.pow(pq.poll(), 2);
            
        }
        
        return answer;
    }
}