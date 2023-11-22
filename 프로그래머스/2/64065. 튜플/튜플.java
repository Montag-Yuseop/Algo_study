import java.util.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<String[]> list = new ArrayList();
        
        s = s.substring(2, s.length()-2);
        s = s.replace("},{", ",,");
        
        String[] sArr = s.split(",,");
        
        for(int i = 0; i < sArr.length; i++) {
            String[] newArr = sArr[i].split(",");
            list.add(newArr);
        }
        
        int cnt = 1;
        HashMap<Integer, Integer> hash = new HashMap();
        
        while(list.size() > 0) {
            for(int i = 0; i < list.size(); i++) {
                String[] temp = list.get(i);
                if(temp.length == cnt) {
                    for(int j = 0; j < temp.length; j++) {
                        int x = Integer.parseInt(temp[j]);
                        if(!hash.containsValue(x)) {
                            hash.put(cnt-1, x);
                            cnt++;  
                        }
                    }
                    list.remove(i);
                }    
            }   
        }
        
        int[] answer = new int[hash.size()];
        for(int i : hash.keySet()) {
            answer[i] = hash.get(i);
        }
        
        
        
        return answer;
    }
}