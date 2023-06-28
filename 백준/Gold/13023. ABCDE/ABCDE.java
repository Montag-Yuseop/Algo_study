import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // N명의 참가 (5 ~ 2000)
    // M개의 관계 (1 ~ 2000)

    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean isOk;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        isOk = false;
        for(int i = 0; i < N; i++) {
            dfs(i, 1);

            if(isOk) break;
        }

        if(isOk) System.out.println(1);
        else System.out.println(0);

    }

    private static void dfs(int node, int depth) {
        if(depth == 5 || isOk) { // 기저조건
            isOk = true;
            return;
        }

        visited[node] = true;
        for(int i : adj[node]) {
            if(!visited[i]) {
                dfs(i, depth+1);
            }
        }
        visited[node] = false;

    }
}