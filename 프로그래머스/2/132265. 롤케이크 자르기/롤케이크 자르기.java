import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 완전 탐색 문제?
        // 케이크 길이만큼 반복문을 돌면서 Set에 넣고 개수를 비교한다?
        // 근데 그렇게 하면 토핑 길이가 백만인데 가능한가? 반복을 두 번 돌아야하는데..
        Map<Integer, Integer> 철수 = new HashMap();
        Map<Integer, Integer> 동생 = new HashMap();
        
        for(int i = 0; i < topping.length; i++) {
            철수.put(topping[i], 철수.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i = 0; i < topping.length; i++) {
            동생.put(topping[i], 동생.getOrDefault(topping[i], 0) + 1);
            
            if(철수.get(topping[i])-1 == 0) {
                철수.remove(topping[i]);
            } else {
                철수.put(topping[i], 철수.get(topping[i])-1);
            }
            
            if(철수.size() == 동생.size()) answer++;
            
        }
        
        
        
        return answer;
    }
}