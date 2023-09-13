class Solution {
    public int solution(String[] board) {
        int answer = 0;
        
        int countO = 0;
        int countX = 0;
        
        char[][] map = new char[3][3];
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                map[r][c] = board[r].charAt(c);
                if(map[r][c] == 'O') countO++;
                else if(map[r][c] == 'X') countX++;
            }
        }
        
        // 기본 조건으로 잘라주고
        if(countO == 0 && countX >= 1) return 0;
        else if(countO >= countX+2) return 0;
        else if(countX >= countO+1) return 0;
        
        // 3개 연속 조건(가로 세로 대각선) 확인 후 숫자 체크
        boolean Obingo = false;
        boolean Xbingo = false;
        
//         for(int r = 0; r < 3; r++) {
//             for(int c = 0; c < 3; c++) {
//                 // 대각선인 경우에
//                 if(r-c == 0 || r+c == 2) {
//                     if(map[r][c] == 'O') {
//                         Obingo = true;
//                         Xbingo = false;
//                     } else if(map[r][c] == '.'){
//                         Obingo = false;
//                         Xbingo = false;
//                     } else if(map[r][c] == 'X') {
//                         Obingo = false;
//                         Xbingo = true;
//                     }
//                 }
                
//                 if(Xbingo || Obingo) break;
                
                // 가로인 경우에
                
            // }
        
        // }
        // 노가다 ㄱㄱ
        if((map[0][0] == 'O' && map[0][1] == 'O' && map[0][2] == 'O') ||
            (map[1][0] == 'O' && map[1][1] == 'O' && map[1][2] == 'O') ||
            (map[2][0] == 'O' && map[2][1] == 'O' && map[2][2] == 'O') ||
            (map[0][0] == 'O' && map[1][0] == 'O' && map[2][0] == 'O') ||
            (map[0][1] == 'O' && map[1][1] == 'O' && map[2][1] == 'O') ||
            (map[0][2] == 'O' && map[1][2] == 'O' && map[2][2] == 'O') ||
            (map[0][0] == 'O' && map[1][1] == 'O' && map[2][2] == 'O') ||
            (map[0][2] == 'O' && map[1][1] == 'O' && map[2][0] == 'O')) {
            Obingo = true;
        }
        if((map[0][0] == 'X' && map[0][1] == 'X' && map[0][2] == 'X') ||
            (map[1][0] == 'X' && map[1][1] == 'X' && map[1][2] == 'X') ||
            (map[2][0] == 'X' && map[2][1] == 'X' && map[2][2] == 'X') ||
            (map[0][0] == 'X' && map[1][0] == 'X' && map[2][0] == 'X') ||
            (map[0][1] == 'X' && map[1][1] == 'X' && map[2][1] == 'X') ||
            (map[0][2] == 'X' && map[1][2] == 'X' && map[2][2] == 'X') ||
            (map[0][0] == 'X' && map[1][1] == 'X' && map[2][2] == 'X') ||
            (map[0][2] == 'X' && map[1][1] == 'X' && map[2][0] == 'X')) {
            Xbingo = true;
        }
        
        if(Obingo && Xbingo) return 0;

        if(Obingo) {
            if(countX >= countO) return 0;
        }
        
        if(Xbingo) {
            if(countO >= countX+1) return 0;
        }
        
        return 1;
    }
}