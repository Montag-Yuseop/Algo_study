import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int weight, value;

        public Node(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }


    public static void main(String[] args) throws IOException {
        // 1. 기본 입출력 사용 가져오기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 어차피 하나만 출력하면 되니까, 스트링 빌더는 사용하지 않는다

        // 2. 물품의 수 N, 버틸 수 있는 무게의 수 K 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /* N개 줄에 걸쳐 각 물건의 무게 W, 가치 V가 주어진다
         * 이 값을 저장하기 위한 테이블을 생성하자
         * N의 최대 크기는 100이므로 메모리 차지가 크진 않다
         * 0번 인덱스부터 사용하면 되겠다
         * 0번 인덱스에 2개의 칼럼을 넣어 2차원 배열로 만들지, Node와 같은 클래스를 만들지
         * 아마 가시적으로 보기에는 클래스를 만드는 것이 좋아보인다. 메서드 변수명으로
         * 확실히 볼 수 있으니까
        */

        // 3. 배낭의 정보를 저장할 클래스와 배열 생성하기
        Node[] items = new Node[N];

        // 4. 배낭 정보 저장
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 5. 값을 저장할 dp배열 생성
        // 행: 아이템의 개수
        // 열: 무게 값
        // 배열 값: 최대 가치
        int[][] dp = new int[N+1][K+1];

        // 6. dp 배열의 값을 넣어주기
        // 최대 100 * 100_000 이므로, 2억(2초)을 넘지 않음
        for(int r = 1; r <= N; r++) {
            Node cur = items[r - 1]; // 현재 노드 값

            for(int c = 1; c <= K; c++) {
                // 7. 현재 무게 인덱스 값이랑 현재 아이템 무게를 더한게 최대 무게를 넘어선 안됨
                if(c - cur.weight >= 0) {
                    dp[r][c] = Math.max(dp[r-1][c], dp[r - 1][c-cur.weight] + cur.value);
                } else {
                    dp[r][c] = dp[r-1][c];
                }
            }
        }

        // 정답은 마지막까지 돌았을 때 최대 무게
        System.out.println(dp[N][K]);

    }
}