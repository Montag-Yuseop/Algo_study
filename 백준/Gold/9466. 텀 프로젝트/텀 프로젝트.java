import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer, N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] check;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            answer = 0;

            arr = new int[N+1];
            visited = new boolean[N+1];
            check = new boolean[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= N; i++) {
                if(check[i]) continue;
                dfs(i);
            }
            sb.append(N - answer).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int now) {
        visited[now] = true; // 방문 처리
        int next = arr[now];


        if(!visited[next]) dfs(next); // 다음 것 방문 안했다면 재귀
        else {
            // 방문 했다면
            if(!check[next]) {
                answer++;
                for(int i = next; i != now; i = arr[i]) {
                    answer++;
                }
            }
        }

        check[now] = true;


    }

}