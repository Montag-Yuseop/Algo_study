import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int w, cost;

        public Node(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

//    static class Node {
//        int w, cost;
//
//        public Node(int w, int cost) {
//            this.w = w;
//            this.cost = cost;
//        }
//    }

    public static void main(String[] args) throws IOException {
        // V(정점 수), E(간선 수)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 리스트 생성 (1 ~ V까지)
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        // List 생성
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            makeList(list, st);
        }

        // 방문 배열 생성
        long answer = findAnswer(list, V, E);

        System.out.println(answer);
    }

    static long findAnswer(ArrayList<ArrayList<Node>> list, int V, int E) {
        long answer = 0;

        // 1. 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();
//        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.cost - o1.cost);

        // 2. 방문 배열 생성
        boolean[] visited = new boolean[V+1];

        // 3. 첫 노드 입력
        pq.offer(new Node(1, 0));

        // 4. pq가 비지 않을 때 까지 반복
        while(!pq.isEmpty()) {
            Node cur = pq.poll(); // 첫 노드 가져오기
            int w = cur.w;
            int cost = cur.cost;

            // 5. 다음 노드를 방문한 적이 없으면 연결된 간선 삽입
            if(!visited[w]) {
                visited[w] = true; // 방문처리
                answer += cost; // 방문한 적이 없는데 가장 먼저 나오면 가장 짧기 때문에 정답에 넣어주기
                for(int i = 0; i < list.get(w).size(); i++) {
                    pq.offer(new Node(list.get(w).get(i).w, list.get(w).get(i).cost));
                }

            }

        }

        return answer;

    }

    static void makeList(ArrayList<ArrayList<Node>> list, StringTokenizer st) {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());

        list.get(x).add(new Node(y, cost));
        list.get(y).add(new Node(x, cost));
    }

}