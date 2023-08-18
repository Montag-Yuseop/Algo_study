import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int N = emergency.length;
        int[] answer = new int[N];
        
        for(int i = 0; i < N; i++) {
            answer[i] = N;
        }
        
        for(int i = 0; i <= N-1; i++) {
            for(int j = i+1; j < N; j++) {
                if(emergency[i] < emergency[j]) {
                    answer[j]--;
                } else {
                    answer[i]--;
                }
            }
        }
        
        
        return answer;
    }
}