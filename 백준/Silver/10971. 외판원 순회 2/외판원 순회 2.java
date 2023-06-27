import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 1번부터 N번까지 번호가 매겨진 도시
    // 순회 여행 경로(한 번 간 도시로는 다시 못가)
    // 가장 적은 비용을 들이고자 한다 - 다시 돌아와야함 근데
    // 도시 수 N (2 <= N <= 10)
    // 비용의 행렬
    static int N;
    static long result = Integer.MAX_VALUE;
    static int[][] city;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        city = new int[N][N];

        // 배열 생성
        for(int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                city[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N]; // 방문 배열은 계속해서 초기화 해주기
            visited[i] = true; // 시작 지점은 방문처리
            dfs(i, i, 0, 0);
        }

        System.out.println(result);
    }

    private static void dfs(int start, int now, int cost, int visit) {
        if(visit == N-1) { // 모두 돌았을 경우 퇴각
            if(city[now][start] != 0) { // 돌아올 수 있는 경우만
                cost += city[now][start];
                result = Math.min(result, cost); // 최솟값으로 변경
            }
            return; // 0이라면 그냥 돌아가
        }

        for(int i = 0; i < N; i++) { // 배열 돌면서 연결된 부분으로 탐색
            if(!visited[i] && city[now][i] != 0) { // 만약 i를 방문하지 않고, 연결이 되어있다면
                if(cost+city[now][i] >= result) {
                    return; // 만약 더한 값이 더 크면 그냥 퇴각해도 될듯?
                }
                // 아니라면
                visited[i] = true; // 방문처리
                dfs(start, i, cost+city[now][i], visit+1);
                visited[i] = false; // 다시 돌려주기
            }
        }

    }


}