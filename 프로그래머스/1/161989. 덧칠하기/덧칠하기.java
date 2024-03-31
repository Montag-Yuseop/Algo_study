class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        
        // section[0] 부터 칠을 시작
        // section[0] + m 만큼 칠한다
        
        int value = section[0];
        
       for(int i : section) {
           // System.out.println(i);
           
           if(i < value + m) {
               continue;
           }
           value = i;
           answer++;
           
       }
        
        
        return answer;
    }
}