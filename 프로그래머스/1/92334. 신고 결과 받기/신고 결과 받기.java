import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 한 유저는 한 명에게 한 번 신고 가능
        // 내가 신고한 유저가 정지되면 정지된 아이디에 저장
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, Set<String>> reportList = new HashMap<>();
        int[] answer = new int[id_list.length];
        
        
        // 유저가 신고 당한 횟수를 저장하는 맵
        for(String s : id_list) {
            map.put(s, 0);
            reportList.put(s, new HashSet<String>());
        }
        
        // 신고 기록을 돌면서 
        for(int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);
            String reportUser = st.nextToken();
            String reportedUser = st.nextToken();
            Set<String> nowSet = reportList.get(reportUser);
            int check = nowSet.size();
            nowSet.add(reportedUser);
            
            reportList.put(reportUser, nowSet);
            
            if(check != nowSet.size()) {
                map.put(reportedUser, map.get(reportedUser) + 1);    
            }
            
        }
        
        // 신고 기록을 저장했으니, 이제 id_list값을 돌면서 증가시켜주자
        for(int i = 0; i < id_list.length; i++) {
            String userName = id_list[i];
            Set<String> temp = reportList.get(userName); // 임시로 가져온다
            
            // set을 돌면서
            for(String s : temp) {
                if(map.get(s) >= k) {
                    answer[i]++;
                }
            }
            
        }
        
//         System.out.println(reportList);
//         System.out.println(map);
        
        
        return answer;
    }
}