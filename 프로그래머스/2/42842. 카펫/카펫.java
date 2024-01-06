import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow; // 총 합(이 수의 약수를 구해야 한다)
        
        int endNum = (int) Math.floor(Math.sqrt(sum)); // 이 수는 반복문을 돌릴 마지막 수
        
        // 1. 1부터 endNum까지 반복문을 돌린다
        for(int i = 1; i <= endNum; i++) {
            // 2. 나누는 i는 작은 수이므로, answer[1]이 가로 값(같거나 더 큰)
            // 갈색은 항상 3이상이어야 한다
            // 따라서 sum을 i로 나눈 약수 중, 조건을 만족하는 숫자(가로 - 2)(세로 - 2)가 yellow 값인 경우를 찾는다
            int width = sum / i;
            int height = i;
            // System.out.println("width = " + width + " height = " + height);
            if((width-2) * (height-2) == yellow) {
                answer[0] = width;
                answer[1] = height;
                return answer;
            }
 
        }
        
        return answer;
    }
}