import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
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


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> list = new ArrayList<>();

        for(int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            makeList(list, st);
        }

        long answer = findNetwork(list, V);

        System.out.println(answer);

    }

    static long findNetwork(ArrayList<ArrayList<Node>> list, int V) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];
        pq.offer(new Node(1, 0));
        long answer = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int w = cur.w;
            int cost = cur.cost;

            if(!visited[w]) {
                visited[w] = true;
                answer += cost;

                for(int i = 0; i < list.get(w).size(); i++) {
                    Node now = list.get(w).get(i);
                    pq.offer(now);
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