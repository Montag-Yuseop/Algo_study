import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1부터 N까지의 수
        M = Integer.parseInt(st.nextToken()); // 길이가 M인 수열

        // 같은 수 여러번 고르기 가능
        // 비내림차순(오름차순)
        arr = new int[M];
        dfs(1, 0);
        System.out.println(sb);

    }

    static void dfs(int v, int depth) { // 정점과 깊이
        // 종료 조건
        // 깊이가 M과 같을 때, 저장된 배열의 값을 sb에 입력하고 종료
        if(depth == M) {
            for(int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = v; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth+1);
        }
    }

}