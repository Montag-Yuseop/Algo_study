import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int v, cost;
        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> adj;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지점 수
            int M = Integer.parseInt(st.nextToken()); // 도로 수
            int W = Integer.parseInt(st.nextToken()); // 웜홀 수

            adj = new ArrayList<>();

            // 인접리스트 생성
            for(int i = 0; i <= N; i++) {
                adj.add(new ArrayList<>());
            }

            // 도로 정보 입력
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                adj.get(a).add(new Node(b, c));
                adj.get(b).add(new Node(a, c));
            }

            // 웜홀 입력
            for(int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                adj.get(a).add(new Node(b, -c ));
            }

            // 벨만포드로 간선 사이클을 점검하면 되겠다
            if(isBack()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }

        }

        System.out.println(sb);
    }

    static boolean isBack() {
        int[] dist = new int[N+1];
        Arrays.fill(dist, 20000000);
        dist[1] = 0; // 첫 위치 0으로 처리
        boolean check = false;

        for(int i = 1; i <= N; i++) {
            check = false;

            for(int j = 1; j<= N; j++) {
                for(Node cur : adj.get(j)) {
                    int next = cur.v;
                    int cost = cur.cost;

                    if(dist[next] > dist[j] + cost) {
                        dist[next] = dist[j] + cost;
                        check = true;
                    }
                }
            }

            if(!check) break;

        }
        if(check) {
            for(int i = 1; i <= N; i++) {
                for(Node cur : adj.get(i)) {
                    int next = cur.v;
                    int cost = cur.cost;

                    if(dist[next] > dist[i] + cost) {
                        return true;
                    }
                }
            }


        }
        return false;
    }

}