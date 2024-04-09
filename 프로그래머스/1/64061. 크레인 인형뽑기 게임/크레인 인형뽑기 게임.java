import java.util.*;


class Solution {
    static int[][] map;
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        map = board;
        Stack<Integer> stk = new Stack<>();
        int N = board.length;
        
        // board = 인형 뽑기 화면
        // moves = 몇 번째에서 뽑을지 정한 것
        
        // moves 순회 하면서
        for(int i = 0; i < moves.length; i++) {
            // 아래로 내려서 뽑아온 인형
            int target = down(N, moves[i] - 1); 
            
            // 0이면 건너 뛰기
            if(target == 0) continue;
            
            // stack이 비어있으면 바로 집어 넣기
            if(stk.isEmpty()) stk.push(target);
            
            // 비어있지 않으면 터트릴 수 있는지 확인하기
            else {
                if(stk.peek() == target) {
                    stk.pop(); // 스택에서 뽑고
                    answer += 2;
                } else {
                    stk.push(target);
                }
            }
            
        }
        
        return answer;
    }
    
    public int down(int N, int number) {
        // 위에서 부터 내려가면서 0이 아닌 숫자를 만나면 해당 숫자를 리턴
        for(int i = 0; i < N; i++) {
            if(map[i][number] != 0) {
                int pop = map[i][number];
                map[i][number] = 0;
                return pop;
            }
        }
        
        return 0;
    }
}