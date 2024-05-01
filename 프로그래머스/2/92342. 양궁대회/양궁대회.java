import java.util.*;

class Solution {
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int[] temp = new int[11]; // 임시 저장용
        int max = 0;
        
        for (int subset = 1; subset <= (1 << 10); subset++) {
            int ryan = 0, apeach = 0, arrow = 0;
            
            for (int i = 0; i < 10; i++) {
                
                // 해당 부분집합이 존재하는 경우(ryan이 맞춘 경우)
                if ((subset & (1 << i)) != 0) {
                    ryan += 10 - i;
                    temp[i] = info[i] + 1;
                    arrow += temp[i];
                } else {
                    temp[i] = 0;
                    if(info[i] > 0) {
                        apeach += 10 - i;
                    }
                }
            }
            
            
            if(arrow > n) continue;
            
            // 남은 화살 다 0으로
            temp[10] = n - arrow;
            
            if (max < ryan - apeach) {
                max = ryan - apeach;
                answer = Arrays.copyOf(temp, temp.length);
            } else if (max == ryan - apeach) {
               for(int i = 10; i >= 0; --i) {
                   if(temp[i] > answer[i]) {
                       answer = Arrays.copyOf(temp, temp.length);
                       break;
                   } else if (temp[i] < answer[i]) break;
               } 
            }
        }
        
        if (max == 0) return new int[]{-1};
        
        return answer;
    }
}