import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int N, maxValue = 0;
    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 인접리스트 생성
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        // 인접리스트 값 입력
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adj.get(x).add(new Node(y, value));
            adj.get(y).add(new Node(x, value));
        }

        findLen(1);
        int answer = findLen(maxValue);
        System.out.println(answer);
    }

    static int findLen(int start) {
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, 100_000_000);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        visited[start] = true;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.v;

            for(Node next : adj.get(now)) {
                int nextV = next.v;
                int cost = next.w;

                if(visited[nextV]) continue;
                visited[nextV] = true;

                if(dist[nextV] > dist[now] + cost) {
                    dist[nextV] = dist[now] + cost;
                    pq.offer(new Node(nextV, dist[now] + cost));
                }
            }
        }
        int temp = 0;
        for(int i = 1; i < N+1; i++) {
            temp = Math.max(temp, dist[i]);
            if (temp == dist[i]) maxValue = i;

        }

        return dist[maxValue];
    }
}