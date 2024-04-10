import java.util.*;

class Solution {
    public int[] solution(int n) {
        int max = (n*(n+1))/2;
        int[] answer = new int[max];
        
        int[][] map = new int[n][n];
        
        int y = -1;
        int x = 0;
        int num = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i % 3 == 0) y++; // 아래부터 시작
                else if(i % 3 == 1) x++; // 오른쪽으로
                else if(i % 3 == 2) { // 대각선으로
                    x--;
                    y--;
                }
                
                map[y][x] = num++;
            }
            
        }
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[idx++] = map[i][j];
            }
        }
        
        return answer;
    }
}