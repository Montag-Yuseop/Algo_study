import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] arr = new boolean[10];
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 100이면 이동 안해도 된다
        if(N == 100) {
            System.out.println(0);
            return;
        }

        // 고장난 버튼이 없다면 숫자 N의 길이만큼 누르면 된다
        if(M == 0) {
            count = Math.min(String.valueOf(N).length(), Math.abs(N-100));
            System.out.println(count);
            return;
        }

        // 고장난 버튼이 있는 경우
        StringTokenizer st = new StringTokenizer(br.readLine());

        // true는 고장난 버튼
        for(int i = 0; i < M; i++) {
            arr[Integer.parseInt(st.nextToken())] = true;
        }

        count = Math.abs(N - 100);
        dfs(0, 1);
        System.out.println(count);
    }

    static void dfs(int check, int idx) {
        for(int i = 0; i < 10; i++) {
            if(!arr[i]) {
                int nextBtn = check * 10 + i;
                int cnt = Math.abs(N - nextBtn) + String.valueOf(nextBtn).length();

                count = Math.min(cnt, count);

                if(idx <= 6) {
                    dfs(nextBtn, idx + 1);
                }
            }


        }

    }

}