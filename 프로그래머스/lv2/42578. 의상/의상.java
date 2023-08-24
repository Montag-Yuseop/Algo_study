import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        // 1. 배열 순회하면서 Map에 넣어주기
        for(int i = 0; i < clothes.length; i++) {
            // 2. 없으면 새로 1과 함께 넣어주기
            if(map.get(clothes[i][1]) == null) {
                map.put(clothes[i][1], 1);
            } else {
            // 3. 해당 의상 종류가 있으면, 기존 값에 +1
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            }
        }
        // 4. 해당 종류의 의상에 +1(안입는 경우) 한 값을 계속 곱해주기
        // keySet을 활용하여 반복
        for(String key : map.keySet()) {
            answer *= (map.get(key)+1);
        }
        
        return answer-1;
    }
}