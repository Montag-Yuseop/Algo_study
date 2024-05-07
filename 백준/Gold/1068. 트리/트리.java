import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adj;
    static int K, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        answer = 0;

        visited = new boolean[N];

        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a == -1) {
                root = i;
                continue;
            }

            adj.get(a).add(i); // i번째 노드의 부모는 a이므로 a 아래에 i를 등록해주자
            adj.get(i).add(a);
        }

        K = Integer.parseInt(br.readLine());

        if(K == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(answer);
        }

    }

    static void dfs(int num) {
        visited[num] = true;
        int cNode = 0;
        for(int i : adj.get(num)) {
            if(!visited[i] && i != K) {
                cNode++;
                dfs(i);
            }
        }

        if(cNode == 0)
            answer++;

    }
}