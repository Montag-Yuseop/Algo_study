import java.util.*;

class Solution {
    
    public static ArrayList<int[]> list = new ArrayList<>(); 
    
    public int[][] solution(int n) {
        
        move(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];
        
        int idx = 0;
        for(int[] i : list) {
            answer[idx++] = i;
        }
        
        return answer;
    }
    
    static void move(int cnt, int start, int mid, int end) {
        if(cnt == 0) return;
        
        move(cnt - 1, start, end, mid);
        list.add(new int[]{start, end});
        move(cnt - 1, mid, start, end);
    }
    
}