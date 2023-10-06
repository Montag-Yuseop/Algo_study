import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        // int answer = 0;
        
//         // 아파트 수 n, 기지국 위치들 station
//         // 범위는 w
        
//         int temp = 0;
//         int range = 2*w+1;
        
//         for(int i = 0; i < stations.length; i++) {
//             int begin = stations[i]-w;
//             int end = stations[i]+w;
            
            
//             if(begin <= 1) {
//                 temp = end;
//                 continue;
//             }    
            
//             answer += (begin-temp-1)/range;
//             if((begin-temp-1)%range != 0) answer += 1;
            
//             temp = end;
            
//         }       
        
//         if(temp < n) {
//             answer += (n-temp)/range;
//             if((n-temp)%range != 0) answer += 1;
//         }
        
        int now = 1;
        int idx = 0;
        int answer = 0;
        while(now <= n) {
            if(idx < stations.length && stations[idx] - w <= now) {
                now = stations[idx++] + w + 1;
            }
            else {
                answer++;
                now += 2*w+1;
            }
        }
        
        
        return answer;
    }
}