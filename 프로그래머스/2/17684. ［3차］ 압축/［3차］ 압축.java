import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        int idx = 1;
        char start = 'A';
        // 사전
        Map<String, Integer> dic = new HashMap<>();
        
        // 기본 알파벳 입력
        for(int i = 0; i < 26; i++) {
            String s = (char) (start + i) +"";
            dic.put(s, idx++);
        }
        
        // 단어 순회하면서 체킹
        for(int i = 0; i < msg.length(); i++) {
            String check = ""; // 체크할 단어
            int temp = 0;
            for(int j = i+1; j <= msg.length(); j++) {
                check = msg.substring(i, j);
                // 단어가 없을 때 까지 하나씩 추가
                // 없으면
                if(dic.get(check) == null) {
                    i = j - 2;
                    break;
                }
                
                // 있으면
                temp = dic.get(check); // 출력할 마지막 idx 저장
                if(j == msg.length()) {
                    i = j;
                }
            }
            answer.add(temp);
            dic.put(check, idx++);
            
        }
        
        return answer;
    }
}