import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        // 시간 초과 해결용 string builder
        StringBuilder answer = new StringBuilder();
        
        // 중복 없이 저장하기 위한 map
        Map<Character, Integer> mapX = new HashMap<>();
        Map<Character, Integer> mapY = new HashMap<>();
        
        // 어떤 값이 들어 있는지 확인하기 위한 list
        // 이건 visited처럼 배열로 0 ~ 9까지 사용해도 괜찮을 듯
        List<Character> list = new ArrayList<>();
        
        // X에 값 채우기
        for(int i = 0; i < X.length(); i++) {
            char c = X.charAt(i); // 타겟 숫자
            
            // c값을 가져오거나 0값으로 초기화 한 뒤 + 1한 값 입력
            mapX.put(c, mapX.getOrDefault(c, 0)+1);
            
            // list에 없으면 해당 값 입력
            if(!list.contains(c)) list.add(c);
        }
        
        // Y에 값 채우기 -> X값과 동일 로직
        for(int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);
            mapY.put(c, mapY.getOrDefault(c, 0)+1);
            if(!list.contains(c)) list.add(c);
        }
        
        // 큰 수부터 넣어주기 위해 역순으로 정렬
        Collections.sort(list, Collections.reverseOrder());
        
        // 리스트 순회
        for(int i = 0; i < list.size(); i++) {
            char c = list.get(i); // 타겟 숫자
            
            // 둘 중 더 적게 나온 숫자를 기준으로 반복
            int x = Math.min(mapX.getOrDefault(c, 0), mapY.getOrDefault(c, 0));
            
            // 해당 숫자를 계속 sb에 입력
            for(int j = 0; j < x; j++) {
                answer.append(c);
            }
        }
        
        // sb의 내용이 비어있으면 아무것도 일치하지 않는 경우
        if(answer.toString().equals("")) return "-1";
        
        //0으로 시작하면 00000과 같은 경우도 0으로 처리
        else if(answer.toString().charAt(0) == '0') return "0";
        
        // 출력
        return answer.toString();
    }
}