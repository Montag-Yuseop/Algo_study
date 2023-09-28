import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        
   
        // 물 웅덩이 -1 처리
        for(int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        
        // 세로 1 처리
        for(int i = 0; i < n; i++) {
            if(map[i][0] == -1) break;
            map[i][0] = 1;
        }
        
        // 가로 1 처리
        for(int i = 0; i < m; i++) {
            if(map[0][i] == -1) break;
            map[0][i] = 1;
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(map[i][j] == -1) continue;
                
                int left = map[i][j-1] % 1000000007;
                int up = map[i-1][j] % 1000000007;
                
                if(left == -1) left = 0;
                if(up == -1) up = 0;
                
                map[i][j] = ((left % 1000000007) + (up % 1000000007))  % 1000000007;
                
            }
        }

        
        // 출력 점검
        // for(int i = 0 ; i < n; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }
        
        
        return map[n-1][m-1] % 1000000007;
    }
    
}