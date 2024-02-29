import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int cnt= 0;
        int idx = 0;
        int now = 0;
        
        // 요청 들어온 순서대로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        // 요청 순서에서 뒤에 종료 시간이 짧은게 가장 처리가 빠른 것
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // 처리된 개수가 job의 길이가 될 때 까지
        while(cnt < jobs.length) {
            
            // job 길이 내에서 현재 시작시간보다 이전의 것들을 전부 pq에 넣어준다
            // idx에 값을 계속 저장해서, 나중에 더 효율적으로 진행할 수 있다
            while(idx < jobs.length && jobs[idx][0] <= now) {
                pq.offer(jobs[idx++]);
            }
            
            // pq가 비어있는 경우, 시작 시간을 변경해준다
            if(pq.isEmpty()) {
                now = jobs[idx][0];
            } else {
                // 비어있지 않은 경우 값들을 변경해준다
                // 가장 종료시간이 빠른 녀석을 가져온다
                int[] cur = pq.poll();
                // answer에 현재 값 + (현재 시점 - 요청 시작 시간) + 작업 길이
                answer += (now - cur[0]) + cur[1];
                now += cur[1]; // 현재 시점에 작업 길이를 더한 값
                cnt++; // 완료 작업 수를 늘려준다
            }
            
            
            
        }
        
        
        
        return (int) Math.floor((double) answer / (double) jobs.length);
    }
}