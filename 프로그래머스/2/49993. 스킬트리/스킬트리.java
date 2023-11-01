import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Map<Character, Integer> map = new HashMap();
        
        for(int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
        
        int n = skill_trees.length;
       
        // 스킬을 돌면서 비교하기
        for(int i = 0; i < n; i++) {
            boolean[] dist = new boolean[skill.length()];
            boolean isOk = true;
            for(int j = 0; j < skill_trees[i].length(); j++) {
                char c = skill_trees[i].charAt(j);               
                if(!map.containsKey(c)) continue;
                int x = map.get(c);
                
                if(x == 0) {
                    dist[0] = true;
                } else {
                    if(dist[x-1]) dist[x] = true;
                    else {
                        isOk = false;
                        break;
                    }
                }
            }
            if(isOk) ++answer;
        }

        
        return answer;
    }
}