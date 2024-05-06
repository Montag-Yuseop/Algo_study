import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        StringTokenizer st;

        arr = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0 ; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        dfs(1);

        for(int i = 2; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    static void dfs(int v) {
        visited[v] = true; // 방문 처리

        for(int i : adj.get(v)) {
            if(!visited[i]) {
                arr[i] = v;
                dfs(i);
            }

        }



    }
}