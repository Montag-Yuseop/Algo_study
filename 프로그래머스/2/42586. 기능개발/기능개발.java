import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList();
        ArrayList<Integer> list = new ArrayList();
            
        for(int i = 0; i < progresses.length; i++) {
            q.offer((int) Math.ceil(((double) 100 - progresses[i]) / speeds[i]));
        }
        
        System.out.println(q);
        
        int now = q.poll();
        int success = 1;
        
        
        while(!q.isEmpty()) {
            int next = q.peek();
            if(next <= now) {
                success++;
                q.poll();
            } else {
                list.add(success);
                success = 1;
                now = q.poll();
            }
        }
        
        list.add(success);
    
        return list;
    }
}