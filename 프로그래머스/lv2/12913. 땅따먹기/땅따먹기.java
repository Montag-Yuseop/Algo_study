import java.util.*;

class Solution {
    static boolean[] visited;
    
    int solution(int[][] land) {
        int answer = 0;
        

        // DP 아니면 dfs 탐색인데?
        // DP 안됨?
        int[][] sum = new int[land.length][4];
        for(int i = 0; i < 4; i++) {
            sum[0][i] = land[0][i];
        }
        
        for(int i = 1; i < land.length; i++) {
            for(int j = 0 ; j < 4; j++) {
                for(int k = 0; k < 4; k++) {
                    // System.out.print("i : " + i + " j : " + j + " k : " + k);
                    if(k == j) continue;
                    sum[i][j] = Math.max(land[i][j] + sum[i-1][k], sum[i][j]);
                    answer = Math.max(answer, sum[i][j]);
                }
                
                
            }
            
        }
        
        // for(int i = 0; i < land.length; i++) {
        //     System.out.println(Arrays.toString(sum[i]));
        // }
        

        
        
        return answer;
    }

    
}