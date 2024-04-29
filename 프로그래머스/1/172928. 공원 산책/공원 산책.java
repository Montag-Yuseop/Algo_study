import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int N = park.length;
        int M = park[0].length();
        
        char[][] map = new char[N][M];
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                map[r][c] = park[r].charAt(c);
                if(map[r][c] == 'S') {
                    answer[0] = r;
                    answer[1] = c;
                }
            }
        }
        
        int[] dr = {0, 0, -1, 1}; // 서, 동, 북, 남
        int[] dc = {-1, 1, 0, 0};
        
        outer: for(String s : routes) {
            String command = s.split(" ")[0];
            int w = Integer.parseInt(s.split(" ")[1]);
            int dir = -1;
            if(command.equals("W")) dir = 0;
            if(command.equals("E")) dir = 1;
            if(command.equals("N")) dir = 2;
            if(command.equals("S")) dir = 3;
            
            int nr = answer[0] + dr[dir] * w;
            int nc = answer[1] + dc[dir] * w;
            
            if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            
            for(int i = 1; i <= w; i++) {
                int nnr = answer[0] + dr[dir] * i;
                int nnc = answer[1] + dc[dir] * i;
                
                if(map[nnr][nnc] == 'X') continue outer;
            }
            
            answer[0] = nr;
            answer[1] = nc;
            
        }
        
        return answer;
    }
}