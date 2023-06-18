import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 도시의 수 N이 주어진다. N <= 200
    // 여행 계획 도시 수 M이 주어진다. M <= 1000
    // N개 줄에는 N개 정수가 주어진다
    // 도시들의 연결 정보가 주어진다(0이면 단절, 1이면 연결)
    // 마지막 줄에는 여행 계획이 주어진다.

    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시의 수
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        // 노드 정보를 담을 배열 생성
        parent = new int[N+1];

        // 대표 노드 설정
        for(int i = 1; i < N; i++) {
            parent[i] = i;
        }

        int[][] map = new int[N+1][N+1]; // 도시 연결 정보를 담을 인접행렬 생성

        // 값 담기
        for(int r = 1; r < N+1; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c < N+1; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] travel = new int[M+1];
        for(int i = 1; i < M+1; i++) {
            travel[i] = Integer.parseInt(st.nextToken());
        }

        // 인접 행열을 탐색하면서, 1이면 union 연산 진행
        for(int r = 1; r < N+1; r++) {
            for(int c = 1; c < N+1; c++) {
                if(map[r][c] == 1) {
                    union(r, c);
                }
            }
        }

        int check = find(travel[1]);
        boolean ok = true;
        for(int i = 2; i < M+1; i++) {
            if(check != find(travel[i])) {
                ok = false;
                break;
            }
        }
        if(ok) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if(a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}