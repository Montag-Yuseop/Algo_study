import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap();
        
        // tangerline 중에서 k개의 귤 고르기 (단 다른 종류를 최소화)
        // map에 귤 크기와 개수를 넣어준다
        for(int size : tangerine) {
            if(map.get(size) == null) {
                map.put(size, 1);
            } 
            else map.put(size, map.get(size)+1);
        }
        
        // map을 정렬해줘야 한다 일단 건너뛰어
        int[] pick = new int[map.size()];
        int idx = 0;
        for(int key : map.keySet()) {
            pick[idx++] = map.get(key);
        }
        
        Arrays.sort(pick);
        for(int i = pick.length-1; i >= 0; i--) {
            k -= pick[i];
            answer++;
            if(k<=0) return answer;
            
        }
        
        return answer;
    }
}