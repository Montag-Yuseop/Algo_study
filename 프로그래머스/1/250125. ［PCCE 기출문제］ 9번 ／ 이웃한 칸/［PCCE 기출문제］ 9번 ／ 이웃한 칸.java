class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int N = board.length;
        String nowColor = board[h][w];
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};
        
        for(int i = 0; i < 4; i++) {
            int nh = h + dr[i];
            int nw = w + dc[i];
            
            if(bc(nh, nw, N)) {
                if(nowColor.equals(board[nh][nw])) answer++;
            }
            
        }
        
        return answer;
    }
    
    public boolean bc(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}