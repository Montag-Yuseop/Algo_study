import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr, answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if(N == 0) break;

            arr = new int[N];
            answer = new int[6];
            visited = new boolean[N];

            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int v, int depth) {
        // 깊이가 0 ~ 5를 채운 상태라면? 6에 도달했을 때
        if(depth == 6) {
            for(int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 도달하지 못했을 때
        for(int i = v; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                dfs(i, depth + 1);
                visited[i] = false;
            }

        }


    }
}