import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static boolean[] answer;
    static boolean isOk;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc < T+1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            visited = new boolean[V+1];
            answer = new boolean[V+1];
            isOk = true;
            adj = new ArrayList[V+1];
            for(int i = 1; i < V+1; i++) {
                adj[i] = new ArrayList<>();
            }

            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adj[x].add(y);
                adj[y].add(x);
            }

            for(int i = 1; i < V+1; i++) {
                if(isOk) {
                    dfs(i);
                } else {
                    break;
                }
            }
            if(isOk) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }

        }
        System.out.println(sb);

    }
    public static void dfs(int x) {
        visited[x] = true;
        for(int i : adj[x]) {
            if(!visited[i]) {
                answer[i] = !answer[x];
                dfs(i);
            } else {
                if(answer[i] == answer[x]){
                    isOk = false;
                    return;
                }
            }
        }
    }

}