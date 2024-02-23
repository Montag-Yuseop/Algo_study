import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        int[][] map = new int[n][m];
        
        
        for(int r = 0; r < n; r++) {
            String s = wallpaper[r];
            for(int c = 0; c < m; c++) {
                char ch = s.charAt(c);
                
                if(ch == '#') map[r][c] = 1;
            }
        }
        
        // for(int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(map[i]));    
        // }
        
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(map[r][c] == 1) {
                    minR = Math.min(minR, r);
                    minC = Math.min(minC, c);
                    maxR = Math.max(maxR, r);
                    maxC = Math.max(maxC, c);
                }
                
            }
        }
        
        answer[0] = minR;
        answer[1] = minC;
        answer[2] = maxR + 1;
        answer[3] = maxC + 1;
        
        return answer;
    }
}