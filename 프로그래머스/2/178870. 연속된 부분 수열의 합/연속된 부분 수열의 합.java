import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        // 투 포인터로 이동하면서 검사해야 한다
        int l = 0;
        int r = 1;
        int sum = sequence[0];
        int len = Integer.MAX_VALUE;
        
        // r이 더 큰 동안 진행
        while(l < r) {
            if(sum == k) {
                if(len > r - l) {
                    len = r - l;
                    answer[0] = l;
                    answer[1] = r-1;
                }
                sum -= sequence[l++];
            }
            
            else if(sum > k) {
                sum -= sequence[l++];
            }
            
            else if(r < sequence.length) {
                sum += sequence[r++];
            }
            else break;
        }
        
        
        return answer;
    }
    
}

// int len = Integer.MAX_VALUE;
        
//         // 마지막 인덱스인데 아직 값을 못찾은 경우도 -1을 반환
//         // 해당 값을 찾은 경우 len을 반환
//         // len이 더 짧은 경우 answer 변환
        
//         for(int i = 0; i < sequence.length; i++) {
//             int now = sequence[i];
//             long sum = 0;
//             for(int j = i; j < sequence.length; j++) {
//                 sum += sequence[j];
                
//                 if(sum > k) break; // 더한 값이 더 커지면 더 볼 필요 없음
                
//                 if(sum == k) {
//                     int temp = Math.min(len, j-i+1); // 더 짧은 길이 선택
//                     // 둘이 같은 경우, len이 변경 없는 경우
//                     // 더 짧은 경우가 있거나 같으면 앞에거 선택
//                     if(temp != len) {
//                         // 이번 경우가 더 짧을 경우
//                         len = temp;
//                         answer[0] = i;
//                         answer[1] = j;
//                     }
//                     break;
//                 }
                
//             }
//         }