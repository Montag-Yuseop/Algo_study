import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for(String s : record) {
            String[] token = s.split(" ");
            String key = token[0];
            String uid = token[1];
            String nickname = "";
            if(!key.equals("Leave")) nickname = token[2];
            
            if(key.equals("Enter")) {
                map.put(uid, nickname);
                list.add(uid+",님이 들어왔습니다.");
            } else if(key.equals("Leave")) {
                list.add(uid+",님이 나갔습니다.");
            } else {
                map.put(uid, nickname);
            }
        }
        String[] answer = new String[list.size()];
        int idx = 0;
        for(String s : list) {
            String[] token = s.split(",");
            String uid = token[0];
            String nickname = map.get(uid);
            
            answer[idx++] = nickname+token[1];   
        }
        
        
        return answer;
    }
}