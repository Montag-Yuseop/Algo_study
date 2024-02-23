import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] formula = new int[4];
    static int[] num;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        // 수열이 주어지고, N-1개의 연산자가 주어진다
        // +, -, *, / 로 이루어져 있다

        // 식의 결과가 최대인 것과 최소인 것을 구해라

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        // 수식 넣기
        for(int i = 0; i < 4; i++) {
            formula[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, num[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int sum) {
        if(depth == num.length) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        int now = num[depth];

        for(int i = 0; i < 4; i++) {
            if(formula[i] == 0 ) continue; // 수식이 없으면 건너 뛰기
            formula[i]--;

            switch(i) {
                case 0 :
                    dfs(depth + 1, sum + now);
                    break;
                case 1 :
                    dfs(depth + 1, sum - now);
                    break;
                case 2:
                    dfs(depth + 1, sum * now);
                    break;
                case 3:
                    dfs(depth + 1, sum / now);
                    break;
            }
            formula[i]++;
        }
    }
}