import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int oneCnt = 0;
        int twoCnt = 0;
        int threeCnt = 0;
        int maxCnt = Integer.MIN_VALUE;
        
        // 정답을 돌면서
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i%5]) ++oneCnt;
            if(answers[i] == two[i%8]) ++twoCnt;
            if(answers[i] == three[i%10]) ++threeCnt;
            maxCnt = Math.max(Math.max(oneCnt, twoCnt), threeCnt);
        }
        
        if(maxCnt == oneCnt) answer.add(1);
        if(maxCnt == twoCnt) answer.add(2);
        if(maxCnt == threeCnt) answer.add(3);
        
        return answer;
    }
}