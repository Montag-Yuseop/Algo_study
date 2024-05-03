import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < enemy.length; i++) {
            n -= enemy[i]; // 병사 제거
            
            pq.offer(enemy[i]); // pq에 삽입
            
            if(n < 0) {
                // 0보다 작아지면 무적권 사용
                if(k > 0 && !pq.isEmpty()) {
                    n += pq.poll();
                    k--;
                } else {
                    return i;
                }
                
            }
            
        }
        
        
        return answer;
    }
}