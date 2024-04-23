import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 연결될 노드 클래스 - 다음 위치, 소요 시간
    public static class Node {
        int v, time;
        public Node(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }

    static ArrayList<ArrayList<Node>> adj = new ArrayList<>(); // 인접리스트 생성
    static int N, M, X;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드 수
        M = Integer.parseInt(st.nextToken()); // 간선 수
        X = Integer.parseInt(st.nextToken()); // 목적지

        // 인접리스트 생성(시작이 1부터기 때문에 N까지 생성)
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        // 인접리스트 연결
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adj.get(x).add(new Node(y, value));
        }

        int answer = Integer.MIN_VALUE;
        int[][] dist = new int[N+1][N+1];

        // 다익스트라 알고리즘 사용
        for(int i = 1; i <= N; i++) {
            dist[i] = go(i);
        }

        for(int i = 1; i <= N; i++) {
            answer = Math.max(answer, dist[i][X] + dist[X][i]);
        }
        System.out.println(answer);
    }

    static int[] go(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.v;

            if(!visited[cur.v]) {
                visited[cur.v] = true;

                for(Node next : adj.get(now)) {
                    if(dist[next.v] > dist[now] + next.time) {
                        dist[next.v] = dist[now] + next.time;
                        pq.offer(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }
        return dist;
    }

}