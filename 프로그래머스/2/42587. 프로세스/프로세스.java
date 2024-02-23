import java.util.*;

class Solution {
    
    static class Node {
        int value, index;
        
        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
        
        public String toString() {
            return value + " " + index;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] more = new int[10];
        
        for(int i = 0; i < priorities.length; i++) {
            int nowNum = priorities[i];
            for(int j = 0; j < nowNum; j++) {
                more[j]++;    
            }
        }
        
        System.out.println(Arrays.toString(more));
        
        Queue<Node> q = new LinkedList();
        
        for(int i = 0; i < priorities.length; i++) {
            q.offer(new Node(priorities[i], i));
        }
        
        while(!q.isEmpty()) {
            Node next = q.peek(); // 맨 위에 큐 내용 확인
            
            // 다음 value보다 우선순위가 높은 것이 없다면
            if(more[next.value] == 0) {
                answer++; // answer 1씩 증가
                Node now = q.poll();
                // more에서 뒤에 애들 전부 -1씩
                for(int i = 1; i < now.value; i++) {
                    more[i]--;
                }
                
                if(now.index == location) {
                    return answer;
                }
                
            } else {
                // 우선순위가 높은 것이 있다면
                Node now = q.poll();
                q.offer(now);
                
                // 넣었다 빼기
            }
            
        }
        
        return answer;
    }
}