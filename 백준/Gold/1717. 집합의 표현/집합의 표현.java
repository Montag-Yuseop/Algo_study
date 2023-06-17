import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 유니온 파인드 문제
    // 1. 각자 자신이 대표 노드인 배열을 하나 만든다.
    // 2. find 연산으로 대표 노드를 찾는다 - 재귀로 구현
    // 3. union 연산으로 2개의 노드를 이용해 각 대표 노드를 찾아서 연결한다
    // 4.

    public static int[] set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        set = new int[n+1]; // 0은 쓰지 않는다

        for(int i = 1; i < n+1; i++) {
            set[i] = i; // 자기 자신을 우선 대표 노드로 설정
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(x == 0) { // 0이면 합치기
                union(a, b); // a와 b 합치기
            } else { // 1이면 비교해서 YES, NO 출력
                if(check(a, b)) {
                    sb.append("YES"+"\n");
                } else {
                    sb.append("NO"+"\n");
                }
            }

        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

    }

    public static void union(int a, int b) {
        if(find(a) != find(b)) {
            set[find(b)] = find(a);
        }
    }

    public static int find(int a) {
        if(a == set[a]) {
            return a;
        } else {
            return set[a] = find(set[a]); // 이 부분이 시간 복잡도 효율성을 위해 추가된 부분
        }
    }

    public static boolean check(int a, int b) {
        if(find(a) == find(b)) {
            return true;
        } else {
            return false;
        }
    }

}