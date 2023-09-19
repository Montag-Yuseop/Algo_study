import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        // Start 지점 -> A 내리고 B 내리기
        // 또는 B 내리고 A 내리기
        // N은 200 (플로이드 워셜 가능)
        // 이 때의 최저 요금을 구한다
        
        // 비용 행렬 생성 (노드 시작 번호가 1부터)
        int[][] cost = new int[n+1][n+1];
        
        // 최댓값으로 초기화
        for(int i = 1; i < n+1; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
            cost[i][i] = 0; // 자기 자신은 0
        }
        
        // 비용 적어주기
        for(int i = 1; i < fares.length+1; i++) {
            cost[fares[i-1][0]][fares[i-1][1]] = fares[i-1][2];
            cost[fares[i-1][1]][fares[i-1][0]] = fares[i-1][2];
        }
        
        // 플로이드 워셜
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if(cost[j][i] == Integer.MAX_VALUE) continue;
                for(int k = 1; k < n+1; k++) {
                    if(cost[i][k] == Integer.MAX_VALUE) continue;
                    cost[j][k] = Math.min(cost[j][i] + cost[i][k] , cost[j][k]);
                }
            }
        }
        
        for(int i = 1; i < n+1; i++) {
            answer = Math.min(cost[s][i] + cost[i][a] + cost[i][b], answer);            
        }
        
        
        // for(int i = 1; i < n+1; i++) {
        //     for(int j = 1; j < n+1; j++) {
        //         if(cost[i][j] == Integer.MAX_VALUE) System.out.print(-1+" ");
        //         else System.out.print(cost[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        
        return answer;
    }
}