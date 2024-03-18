import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> adj;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        // wires는 전력망이 연결된 정보를 나타낸다
        // 연결된 전력망의 차이가 정답에 들어간다
        // 깊이 우선 탐색을 통해 wires에서 하나씩 뺀 다음 연결된 송전탑의 수를 세서 차이를 구한다
        // answer가 가장 작은 경우를 정답에 담아 출력한다
        // 탐색은 한 번만해서 연결된 송전탑 수를 구하고, n개에서 해당 송전탑 수를 빼면 나머지가 나오니까 그 차이를 구한다
        // ex) 9개 중 3개 연결 -> 3개, 9-3(6개) = n - 2*연결 수
        
        adj = new ArrayList<>();
        
        // 연결리스트 생성
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++) {
            adj.get(wires[i][0]).add(wires[i][1]);
            adj.get(wires[i][1]).add(wires[i][0]);
        }
        
        
        // 연결리스트에 연결 안 된 부분을 제거하면서 탐색을 반복한다
        // 탐색 후 다시 연결해준다
        for(int i = 0; i < wires.length; i++) {
            int v1 = adj.get(wires[i][0]).indexOf(wires[i][1]);
            int v2 = adj.get(wires[i][1]).indexOf(wires[i][0]);
            
            adj.get(wires[i][0]).remove(v1);
            adj.get(wires[i][1]).remove(v2);
            
            int cnt = bfs(n);
            answer = Math.min(answer, Math.abs(n - 2 * cnt));
            
            adj.get(wires[i][0]).add(wires[i][1]);
            adj.get(wires[i][1]).add(wires[i][0]);
        }
        
        return answer;
    }
    
    static int bfs(int n) {
        boolean[] visited = new boolean[n+1]; // 방문 배열 생성
        int cnt = 1; // 연결된 노드 수
        Queue<Integer> q = new LinkedList<>(); // q생성
        q.offer(1); // 시작 노드 넣기
        visited[1] = true;

        while(!q.isEmpty()) {
            int num = q.poll(); // 노드 빼기
            for(int i : adj.get(num)) { // 해당 노드의 연결점 돌면서 진행
                if(!visited[i]) { // 방문 안한 노드는 q에 넣기
                    visited[i] = true;
                    cnt++; // 노드 수 증가
                    q.offer(i); // 새로운 노드 삽입
                }
            }
            
        }
        
        return cnt;
        
    }
}