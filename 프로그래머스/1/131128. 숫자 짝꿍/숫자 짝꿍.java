import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        Map<Character, Integer> mapX = new HashMap<>();
        Map<Character, Integer> mapY = new HashMap<>();
        
        List<Character> list = new ArrayList<>();
        
        for(int i = 0; i < X.length(); i++) {
            char c = X.charAt(i);
            mapX.put(c, mapX.getOrDefault(c, 0)+1);
            if(!list.contains(c)) list.add(c);
        }
        
        for(int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);
            mapY.put(c, mapY.getOrDefault(c, 0)+1);
            if(!list.contains(c)) list.add(c);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        for(int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            
            int x = Math.min(mapX.getOrDefault(c, 0), mapY.getOrDefault(c, 0));
            
            for(int j = 0; j < x; j++) {
                answer.append(c);
            }
        }
        if(answer.toString().equals("")) return "-1";
        else if(answer.toString().charAt(0) == '0') return "0";

        return answer.toString();
    }
}