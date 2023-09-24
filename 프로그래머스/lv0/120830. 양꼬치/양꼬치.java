class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        if(n >= 10) {
            answer = 12000*n + (k-(n/10))*2000;
        } else {
            answer = answer = 12000*n + k*2000;
        }
        
        return answer;
    }
}