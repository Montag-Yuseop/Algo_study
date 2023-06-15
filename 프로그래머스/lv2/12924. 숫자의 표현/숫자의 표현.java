class Solution {
    public int solution(int n) {
        int answer = 0; // 자기 자신은 무적권 포함
        
        int start = 1;
        int end = 1;
        int sum = 1;
        
        while(end <= n) {
            if(sum == n) {
                answer++;
                end++;
                sum += end;
            } else if(sum > n) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            } 
        }
 
        return answer;
    }
}