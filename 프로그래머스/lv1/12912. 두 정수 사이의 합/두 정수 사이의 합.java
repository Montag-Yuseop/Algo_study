class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a == b) return a;
        
        long min = (a < b) ? a : b;
        long max = (a < b) ? b : a;
        
        answer = ((max * (max+1)) - ((min-1) * min)) / 2;
        
        // for(int i = min; i <= max; i++){
        //     answer += i;
        // }
        
        return answer;
    }
}