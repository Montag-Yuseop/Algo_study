import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        int N = board.length; // 가로
        int M = board[0].length; // 세로
        
        if(N <= 1 || M <= 1) {
            boolean ok = false;
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    if(board[r][c] == 1) {
                        ok = true;
                        break;
                    }
                }
            }
            if(ok) return 1;
            else  return 0;
        }
        
        
        for(int r = 1; r < N; r++) {
            for(int c = 1; c < M; c++) {
                if(board[r][c] == 1) {
                    board[r][c] = Math.min(board[r-1][c-1], Math.min(board[r-1][c], board[r][c-1])) + 1;
                }
                answer = Math.max(answer, board[r][c]);
                
            }
        }
        

        return answer * answer;
    }
}