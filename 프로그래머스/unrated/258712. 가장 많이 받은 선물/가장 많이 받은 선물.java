import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 친구들 이름을 Map에 index화 하여 저장한다
        // key: name , value: index
        
        Map<String, Integer> name = new HashMap<>();
        int index = 0;
        for(int i = 0; i < friends.length; i++){
            name.put(friends[i], index++);
        }
        
        // gifts 명단을 통해 누가 누구에게 선물을 줬는지 확인한다
        int size = friends.length;
        int[][] giftCount = new int[size][size];
        
        // 배열에 해당 정보를 저장한다
        for(String s : gifts){
            StringTokenizer st = new StringTokenizer(s);
            
            String first = st.nextToken();
            String last = st.nextToken();
            
            giftCount[name.get(first)][name.get(last)]++;
            
        }
        
        // 선물 지수를 맵에 저장한다
        Map<String, Integer> giftZisu = new HashMap<>();

        for(int r = 0; r < giftCount.length; r++) {
            int temp = 0;
            
            for(int c = 0; c < giftCount.length; c++) {
                if(r == c) continue; // 같은 부분에선 건너뛰어라
                int AtoB = giftCount[r][c];
                int BtoA = giftCount[c][r];
                
                temp += AtoB;
                temp -= BtoA;
            
            }
            
            // temp에 저장한 값이 곧 선물 지수(이름, 지수)
            giftZisu.put(friends[r], temp);
        }
                
        // 받을 선물을 저장할 배열을 만들자
        int[] answer = new int[friends.length];        
        
        // 이제 선물 지수가 만들어졌으므로, 비교가 가능해짐
        for(int r = 0; r < giftCount.length; r++) {
            for(int c = 0; c < giftCount.length; c++) {
                if(r == c) continue;
                
                int AtoB = giftCount[r][c];
                int BtoA = giftCount[c][r];
                
                if(AtoB == BtoA) {
                    int aZisu = giftZisu.get(friends[r]);
                    int bZisu = giftZisu.get(friends[c]);
                    
                    if(aZisu == bZisu) continue;
                    else if(aZisu > bZisu) answer[r]++;
                    else answer[c]++;
                } else if(AtoB > BtoA) 
                    answer[r]++;
                
                else answer[c]++;                
                
            }
        }
        
        int result = 0;
        for(int i : answer) {
            result = Math.max(result, i/2);
        }
        
        
        return result;
    }
}