class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = Integer.bitCount(n);
        int temp = 0;
        while(true) {
            n++;
            temp = Integer.bitCount(n);
            if(cnt == temp) {
                answer = n;
                break;
            }
        }
        
        
        return answer;
    }
}