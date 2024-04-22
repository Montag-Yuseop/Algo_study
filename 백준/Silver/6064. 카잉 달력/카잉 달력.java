import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // M과 N보다 작거나 같은 두 개의 자연수 x,y로 년도를 <x:y> 형식 표기
        // <1:1>이 처음, <2:2> 두 번째 해
        // x < M이면 그 다음 년도는 x = x+1, 아니면 x=1
        // y도 마찬가지
        // M, N은 종말

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        outer: for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            int max = M * N / gcd(M, N);

            for(int i = x; i <= max; i+=M) {
                if(i % N == y) {
                    System.out.println(i+1);
                    continue outer;
                }

            }
            System.out.println(-1);


        }



    }

    static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}