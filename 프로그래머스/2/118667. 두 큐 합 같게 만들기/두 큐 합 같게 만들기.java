import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>(); // 1번 큐
        Queue<Integer> q2 = new LinkedList<>(); // 2번 큐
        long sumQ1 = 0;
        long sumQ2 = 0;
        int N = queue1.length;
        
        for(int i = 0; i < N; i++) {
            sumQ1 += queue1[i];
            sumQ2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        long total = sumQ1 + sumQ2;
        if(total % 2 != 0) return -1;
        
        long target = total/2;
        while(answer <= N * 4 ) {
            if(sumQ1 == target || sumQ2 == target) return answer;
            
            if(sumQ1 > sumQ2) {
                sumQ1 -= q1.peek();
                sumQ2 += q1.peek();
                q2.offer(q1.poll());
            } else {
                sumQ2 -= q2.peek();
                sumQ1 += q2.peek();
                q1.offer(q2.poll());
            }
            
            answer++;
        }
        
        return -1;
    }
}