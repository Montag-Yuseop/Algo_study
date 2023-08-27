import java.util.*;

public class Solution {
    public Queue<Integer> solution(int []arr) {

        // 1. 넣은 순서대로 출력해야 한다. 따라서 Queue를 사용
        Queue<Integer> answer = new LinkedList();
        
        // 2. null 값 방지를 위해 배열의 처음 숫자를 먼저 넣어준다
        answer.offer(arr[0]);
        
        for(int i = 1; i < arr.length; i++) {
            // 3. 맨 위에 peek해서 비교해보고 같으면 안넣고, 다르면 넣는다
            if(arr[i] != arr[i-1]) {
                answer.offer(arr[i]);
            }
        }

        return answer;
    }
}