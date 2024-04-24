import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        // adj 생성
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향
            adj.get(a).add(new Node(b, c));
            adj.get(b).add(new Node(a, c));
        }

        // 반드시 들려야 하는 두 정점
        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        // 1 -> first -> second -> N
        // 1 -> second -> first -> N
        // 둘 중 더 짧은 거리를 비교
        long caseOne = 0;
        caseOne += dijkstra(1, first);
        caseOne += dijkstra(first, second);
        caseOne += dijkstra(second, N);

        long caseTwo = 0;
        caseTwo += dijkstra(1, second);
        caseTwo += dijkstra(second, first);
        caseTwo += dijkstra(first, N);

        long answer = (caseOne >= 200000000 && caseTwo >= 200000000) ?
                -1 : Math.min(caseOne, caseTwo);

        System.out.println(answer);
    }

    public static long dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(start, 0));
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];

        Arrays.fill(dist, 200000000);
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.v;

            if(visited[now]) continue;
            visited[now] = true;

            for(Node next : adj.get(now)) {
                int nextV = next.v;
                int nextCost = next.cost;
                if(!visited[nextV] && dist[nextV] > nextCost + dist[now]) {
                    dist[nextV] = nextCost + dist[now];
                    pq.offer(new Node(nextV, dist[nextV]));
                }
            }
        }

        return dist[end];
    }

}