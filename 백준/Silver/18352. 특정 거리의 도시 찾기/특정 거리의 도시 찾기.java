import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static public class Node {
        int x, w;

        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }

    static ArrayList<Integer>[] adj;
    static int N, M, K, X;
    static List<Integer> ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시 개수 - 노드
        M = Integer.parseInt(st.nextToken()); // 도로 개수 - 간선
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 번호
        visited = new boolean[N+1]; // 방문 정보 저장
        ans = new ArrayList<>();

        // 인접 리스트 생성
        adj = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y); // 연결 정보 저장
        }

//        for(int i = 1; i < N+1; i++) {
//            System.out.println(adj[i]);
//        }

        bfs(X, 0);
        if(ans.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(ans);
            for(int i : ans) {
                System.out.println(i);
            }
        }

    }

    public static void bfs(int x, int w) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, w));
        visited[x] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.w == K) {
                ans.add(cur.x);
            }
            for(int n : adj[cur.x]) {
                if(!visited[n]) {
                    q.offer(new Node(n, cur.w+1));
                    visited[n] = true;
                }
            }
        }
    }
}