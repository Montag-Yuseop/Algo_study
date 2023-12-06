import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 먼저 출발하는 트럭부터 출력되므로, Queue 사용
        Queue<Integer> truck = new LinkedList<>(); 
        
         // 다리를 구현해서 트럭의 q를 하나씩 집어넣을 것
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i = 0; i < truck_weights.length; i++) {
            truck.offer(truck_weights[i]);
        }
        
        for(int i = 0; i < bridge_length; i++){
            bridge.offer(0);
        }
        
        int sum = 0;
        
        while(!bridge.isEmpty()) { // 다리에 아무것도 안남을 때 까지
            answer++; // 하나 뺄 때마다 1초
            sum -= bridge.poll(); // 빼낸 값을 전체 무게에서 빼주자 - 나중에 트럭이 bridge 큐에 올라오면 올라갔다가 나가면 빠짐
            if(!truck.isEmpty()) { // 트럭이 다 빠지면 bridge 가 알아서 쭉 빠져나갈것
                if(truck.peek()+sum <= weight ){ // 가장 앞의 트럭 무게와 현재 다리에 올라간 트럭들의 무게 합이 최대 하중보다 작다면
                    int x = truck.poll(); // 빼낸 값을 x에 담아서
                    sum += x; // sum에 x를 더해주고
                    bridge.offer(x); // 다리위에 올려준다
                } else { // 만일 무게가 더 크다면, 0을 집어넣고 다음 반복에서 맨 앞을 빼서 다리를 앞으로 밀어준다
                    bridge.offer(0);
                }
            }
            // System.out.println(bridge); 구경용
        }
        
        return answer;
    }
}