class Solution {
    public int solution(long num) {
        int answer = 0;
        if(num == 1) return answer;
        
        while(true) {
            
            answer++;
            if(answer >= 500) {
                answer = -1;
                return answer;
            }
            
            if((num % 2) == 0) {
                num = num/2;
            } else {
                num = 3*num + 1;
            }
           
            if(num == 1) {
                return answer;
            }
            
        }
    }
}