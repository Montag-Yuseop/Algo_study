import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        int temp = n;
        while(temp >= 10) {
            answer += temp % 10;
            temp /= 10;
        }
        answer += temp;

        return answer;
    }
}