import java.util.*;

class Solution {
    static class Node{
        String key;
        int[] value;
        
        public Node(String key, int[] value) {
            this.key = key;
            this.value = value;
        }
    }
    
    
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        // 오늘 날짜를 배열에 저장(0: 연도, 1: 달, 2: 일)
        String[] nowDate = today.split("\\.");
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st;
        
        // 약관 저장(A 정책 = x 달 형식)
        for(String s : terms) {
            st = new StringTokenizer(s);
            String key = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            map.put(key, value);
        }
        
        // 정책 저장
        Node[] priv = new Node[privacies.length];
        
        for(int t = 0; t < privacies.length; t++) {
            String s = privacies[t];
            st = new StringTokenizer(s);
            int[] values = new int[3];
            String temp = st.nextToken();
            String keys = st.nextToken();
            
            st = new StringTokenizer(temp, ".");
            for(int i = 0; i < 3; i++) {
                values[i] = Integer.parseInt(st.nextToken());
            }
            
            priv[t] = new Node(keys, values);
        }
        
        for(int i = 0; i < priv.length; i++) {
            // priv에는 Node가 저장되어 있음
            Node cur = priv[i];
            int startYear = cur.value[0];
            int startMonth = cur.value[1];
            int startDay = cur.value[2];
            String val = cur.key;
            
            int todayYear = Integer.parseInt(nowDate[0]);
            int todayMonth = Integer.parseInt(nowDate[1]);
            int todayDay = Integer.parseInt(nowDate[2]);
            
            int temp = map.get(val);
            
            startMonth += temp; //시작 날짜에 유효 기간을 더한다
            startYear += startMonth / 12; // 12로 나눈 값의 몫을 더한다 (월이 초과된 경우)
            startMonth %= 12; // 12로 나눈 값의 나머지를 사용한다
            
            if(startMonth == 0) {
                startMonth = 12;
            }
            
            if(startMonth % 12 == 0) {
                startYear -= 1;
            } else if(startMonth % 24 == 0) {
                startYear -= 2;
            } else if(startMonth % 36 == 0) {
                startYear -= 3;
            }
            
            // System.out.println(startYear+" "+startMonth);

            // 이제 today와 start를 비교해서 today가 더 크면 리스트에 i+1을 추가한다
            if(todayYear - startYear > 0 ) {
                answer.add(i+1);
            } else if(todayYear == startYear) {
                // 같은 경우
                if(todayMonth - startMonth > 0) {
                    answer.add(i+1);
                } else if(todayMonth == startMonth) {
                    if(todayDay - startDay >= 0) {
                        answer.add(i+1);
                    }
                }
                
            }
            
        }
        return answer;
    }
}