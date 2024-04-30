import java.util.*;

class Solution {
    
    static class Node {
        int v, cost;
        
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // 양방향 도로, 1번 마을에서 K 시간 이하로 배달 가능한 마을만 주문
        // 1. 인접리스트 생성
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        // 2. 정보 입력
        for(int i = 0; i < road.length; i++) {
            int x = road[i][0];
            int y = road[i][1];
            int z = road[i][2];
            
            adj.get(x).add(new Node(y, z));
            adj.get(y).add(new Node(x, z));
        }
        
        // 3. 방문 배열과 거리 배열 초기화
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, 100_000_000); // 1억으로 초기화(최대 50만 * 50개의 마을 -> 충분한 크기)
        
        // 4. 다익스트라 알고리즘 수행
        findOrder();
        
        answer = countCity(K);

        return answer;
    }
    
    static int countCity(int K) {
        int ans = 0;
        
        for(int i : dist) {
            if(i <= K) ans++;
        }
        
        return ans;
    }
    
    static void findOrder() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(1, 0)); // 시작 지점 입력
        dist[1] = 0; // 시작 지점 거리는 0으로 초기화
        visited[1] = true; // 시작지점 방문처리
        
        while(!pq.isEmpty()) {
            // 큐에 내용물을 빼면서 거리를 계속 갱신
            Node cur = pq.poll();
            int now = cur.v;
            
            // 현재 마을과 연결된 노드들을 가져와서 수행
            for(Node next : adj.get(now)) {
                int nextV = next.v;
                int cost = next.cost;
                
                if(dist[nextV] > dist[now] + cost) {
                    visited[nextV] = true; // 다음 지점 방문처리
                    dist[nextV] = dist[now] + cost;
                    pq.offer(new Node(nextV, dist[nextV]));
                }
                
            }
            
        }
        
    }
    
}