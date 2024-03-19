import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n+1];
        
        for(int i = 1; i < student.length; i++) {
            student[i] = 1;
        }
        
        for(int i = 0; i < lost.length; i++) {
            int temp = lost[i];
            student[temp]--;
        }
        
        for(int i = 0; i < reserve.length; i++) {
            int temp = reserve[i];
            student[temp]++;
        }

        // 해당 학생의 체육복 수가 0이면 한 칸 앞에서 받아오고, 앞에도 0이면 한 칸 뒤에서 받아온다
        for(int i = 1; i < n; i++) {
            if(student[i] == 0) {
                if(student[i-1] > 1) {
                    --student[i-1];
                    ++student[i];
                } else if(student[i+1] > 1){
                    --student[i+1];
                    ++student[i];
                }
            }
        }
        
        if(student[n] == 0) {
            if(student[n-1] > 1) {
                --student[n-1];
                ++student[n];
            }
        }
        

        
        for(int i = 1; i <= n; i++) {
            if(student[i] >= 1) {
                answer++;
            }
        }
        
        return answer;
    }
}