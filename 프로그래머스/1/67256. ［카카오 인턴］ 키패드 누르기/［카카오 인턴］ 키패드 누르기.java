import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int nowR = 10;
        int nowL = 12;
        /*
        1   2   3
        4   5   6
        7   8   9
        10  11 12
        */
        
        // numbers를 돌면서 진행
        for(int num : numbers) {
            
            // 1, 4, 7이면 왼 손 사용
            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                nowL = num;
            } 
            // 3, 6, 9면 오른손 사용
            else if(num == 3 || num == 6 || num == 9) {
                sb.append("R");
                nowR = num;
            } 
            // 2, 5, 8, 0인 경우는 더 가까운 경우로
            // 0은 11로 변경해서 계산하자
            else {
                if(num == 0) num = 11;
                
                int lDist = Math.abs(num-nowL)/3 + Math.abs(num-nowL) % 3;
                int rDist = Math.abs(num-nowR)/3 + Math.abs(num-nowR) % 3;
                
                if(lDist < rDist) {
                    nowL = num;
                    sb.append("L");
                } else if(lDist > rDist) {
                    nowR = num;
                    sb.append("R");
                } else { // 같은 경우
                    if(hand.equals("right")) {
                        nowR = num;
                        sb.append("R");
                    } else {
                        nowL = num;
                        sb.append("L");
                    }
                    
                }
                
            }
            
        }
        
        return sb.toString();
    }
}