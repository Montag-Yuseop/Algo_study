import java.util.*;

class Solution {
    
    static class Node {
        int next, cost;
        
        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] cost : costs) {
            int x = cost[0];
            int y = cost[1];
            int z = cost[2];
            
            adj.get(x).add(new Node(y, z));
            adj.get(y).add(new Node(x, z));
        }
        
        answer = createRoad(n, costs, adj);
        
        
        return answer;
    }
    
    static int createRoad(int n, int[][] costs, ArrayList<ArrayList<Node>> adj) {
        int answer = 0;
        
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        // int[] dist = new int[n+1];
        // Arrays.fill(dist, 100_000_000);
        // dist[1] = 0;
        // visited[1] = true;
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.next;
            int cost = cur.cost;
            
            if (!visited[now]) {
                visited[now] = true;
                answer += cost;
                
                for (Node next : adj.get(now)) {
                    int nextV = next.next;
                    int nextCost = next.cost;
                    pq.offer(new Node(nextV, nextCost));
                }
                
            }
        }
        
        return answer;
    }
}   