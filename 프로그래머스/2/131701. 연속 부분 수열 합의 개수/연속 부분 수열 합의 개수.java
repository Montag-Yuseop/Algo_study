import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        // 정답을 넣을 set 생성
        Set<Integer> set = new HashSet<>();
        
        // 최대 사이즈는 elements
        // i 갯수만큼 반복문 시행
        for(int i = 1; i <= elements.length; i++) {
            // 원소 배열의 시작점
            for(int j = 0; j < elements.length; j++) {
                int sum = 0; // 0으로 초기화
                // 1개 뽑을 때 -> 0, 1, 2, 3, 4
                // 2개 뽑을 때 -> 01, 12, 23, 34, 40(elements length의 나머지 활용)
                for(int k = 0; k < i; k++) {
                    sum += elements[(j + k) % elements.length];
                }
                set.add(sum);
            }
        }
        int sum = 0;

        answer = set.size();
        
        return answer;
    }
}