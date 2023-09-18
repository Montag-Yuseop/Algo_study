import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        int N = triangle.length;
        
        int[][] sum = new int[N][N];
        sum[0][0] = triangle[0][0];
        
        for(int i = 1; i < N; i++) {
            sum[i][0] = sum[i-1][0] + triangle[i][0];
            sum[i][i] = sum[i-1][i-1] + triangle[i][i];
        }
        
        
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 1; j < i; j++) {
                sum[i][j] = Math.max(sum[i-1][j-1] + triangle[i][j], sum[i-1][j] + triangle[i][j]);
            }
        }
        
        for(int i = 0; i < N; i++) {
            answer = Math.max(sum[N-1][i], answer);
        }
        
        return answer;
    }
}