import java.util.*;

class Solution {
    
    static int answer = 100_000_000;
    
    public int solution(int[] picks, String[] minerals) {
        
        for(int i = 0; i < picks.length; i++) {
            if(picks[i] == 0) continue;
            picks[i]--;
            dfs(picks, minerals, 0, 0, i);    
            picks[i]++;
        }
        
        
        if(answer == 100_000_000) answer = 0;
        return answer;
    }
    
    static void dfs(int[] picks, String[] minerals, int sum, int idx, int nowPick) {

        // 종료 조건: 곡괭이가 모두 소모됐을 때 또는 인덱스 + 5가 minerals보다 커졌을 때
        if(idx >= minerals.length) {
            answer = Math.min(answer, sum);
            return;
        }
        
        // body
        // 현재 상태의 피로도 구하기
        sum += getCount(minerals, nowPick, idx);
        // System.out.println("idx = " + idx + " sum = " + sum);
        
        
        // picks에서 0이 아닌 녀석들을 돌면서 재귀조건 진행          
        int check = 0;
        
        for(int i = 0; i < picks.length; i++) {
            if(picks[i] == 0) {
                check++;
                continue;
            }
            
            picks[i]--;
            dfs(picks, minerals, sum, idx + 5, i);
            picks[i]++;
             
        }
        
        if(check == 3) {
            // System.out.println(Arrays.toString(picks));
            // System.out.println("now = " + sum + " answer = " + answer);
            answer = Math.min(answer, sum);
            return;
        };
        
    }
    
    static int getCount(String[] minerals, int nowPick, int index) {
        int cnt = 0;
        int end = Math.min(index + 5, minerals.length);
        for(int i = index; i < end; i++) {
            String mineral = minerals[i];
            
            // 다이아
            if(nowPick == 0) {
                cnt += 1;
            } 
            // 철
            else if(nowPick == 1) {
                if(mineral.equals("diamond")) cnt += 5;
                else cnt += 1;
            }
            // 돌
            else {
                if(mineral.equals("diamond")) cnt += 25;
                if(mineral.equals("iron")) cnt += 5;
                if(mineral.equals("stone")) cnt += 1;
            }

        }
        
        // System.out.println("여기: " + index +" " + cnt);
        return cnt;
        
        
    }
    
}