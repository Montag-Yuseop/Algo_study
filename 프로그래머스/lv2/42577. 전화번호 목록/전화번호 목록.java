import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, String> map = new HashMap<>();
        
        // 1. 배열에 있는 전화번호를 해쉬맵에 넣는다
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], phone_book[i]);
        }
        
        // 2. 배열만큼 돌린다(배열 최대 길이 = 1,000,000)
        for(int i = 0; i < phone_book.length; i++) {
            // 3. 해당 문자열 길이만큼 돌린다(1~20) -> 최대 20 * 1,000,000 = 20,000,000(0.2초)
            for(int j = 0; j < phone_book[i].length(); j++) {
                // 4. map에 있는지 검사
                if(map.containsKey(phone_book[i].substring(0, j))) {
                    // 5. 있으면 answer를 false로
                    answer = false;
                    return answer; // 그리고 끝내기
                }
                
            }
        }
     
        return answer;
    }
}