import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] map = new int[rows][columns];
        int idx = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                map[r][c] = ++idx;
            }
        }
        
        // for (int[] i : map) {
        //     System.out.println(Arrays.toString(i));
        // }
        
        
        // 쿼리 만큼 시계방향 회전하기
        for(int i = 0; i < queries.length; i++) {
            // if(i != 0) break;
            answer[i] = move(map, queries[i]);
        }
        
        // for (int[] i : map) {
        //     System.out.println(Arrays.toString(i));
        // }
        
        
        return answer;
    }
    
    // 회전하는 메서드 생성
    static int move(int[][] map, int[] queries) {
        int x1 = queries[0] - 1, y1 = queries[1] - 1, x2 = queries[2] - 1, y2 = queries[3] - 1;
        // System.out.println(x1+ " " + y1 +" "+ x2 +" " + y2);
        // (1,1) -> (1,2) / (1,2) -> (1,3) - 2번? y2 - y1
        // (1,3) -> (2,3) / (2,3) -> (3,3) / (3,3) -> (4,3) - 3번 x2 - x1
        // (4,3) -> (4,2) / (4,2) -> (4,1) - 2번
        // (4,1) -> (3,1) / (3,1) -> (2,1) / (2,1) -> (1,1) - 3번
        
        // y2 - y1만큼 좌우로 이동
        // x2 - x1만큼 상하로 이동
        
        int[][] copy = new int[map.length][map[0].length];
        for(int r = 0; r < map.length; r++) {
            for(int c = 0; c < map[0].length; c++) {
                copy[r][c] = map[r][c];
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        // 우로 한칸
        for(int i = y1 + 1; i <= y2; i++) {
            map[x1][i] = copy[x1][i-1];
            min = Math.min(min, map[x1][i]);
        }
        
        // 아래로 한칸
        for(int i = x1 + 1; i <= x2; i++) {
            map[i][y2] = copy[i-1][y2];
            min = Math.min(min, map[i][y2]);
        }
        
        // 좌로 한칸
        for(int i = y2; i > y1; i--) {
            map[x2][i-1] = copy[x2][i];
            min = Math.min(min, map[x2][i-1]);
        }
        
        // 위로 한칸
        for(int i = x2; i > x1; i--) {
            map[i-1][y1] = copy[i][y1];
            min = Math.min(min, map[i-1][y1]);
        }
        
        return min;
    }
}