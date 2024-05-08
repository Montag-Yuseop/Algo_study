import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int[] arr, map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        arr = new int[M];
        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);
        dfs(0, 0, N, M);

        System.out.println(sb);
    }

    static void dfs(int num, int depth, int N, int M) {
        if(depth == M) {
            for(int i : arr) {
                sb.append(i).append(" ");
            }

            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
//            if(!visited[i]) {
//                visited[i] = true;
                arr[depth] = map[i];
                dfs(i, depth + 1, N, M);
//                visited[i] = false;
//            }

        }

    }

}