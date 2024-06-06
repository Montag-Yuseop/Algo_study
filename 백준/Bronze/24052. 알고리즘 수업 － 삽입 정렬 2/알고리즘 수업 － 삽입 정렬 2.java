import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 삽입 정렬 구현해야 함

        // 1. 배열 생성 및 입력
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 횟수를 비교할 변수 생성
        int cnt = 0;

        // 3. 삽입 정렬 구현
        // 0은 어차피 이전것이 없으니까 정렬 안해도 된다
        boolean isOk = false;
        outer: for (int i = 1; i < N; i++) {
            int loc = i - 1; // i 이전까지의 인덱스들
            int newItem = arr[i]; // 바꿀 값

            while (0 <= loc && newItem < arr[loc]) {
                arr[loc + 1] = arr[loc--];
                cnt++; // 변경 횟수 증가
                if(check(cnt, K, arr)) {
                    isOk = true;
                    break outer;
                }
            }

            if (loc + 1 != i) {
                arr[loc + 1] = newItem;
                cnt++;
                if(check(cnt, K, arr)) {
                    isOk = true;
                    break outer;
                }
            }
        }
        if(!isOk) System.out.println(-1);

    }

    static boolean check(int cnt, int K, int[] arr) {
        if(cnt == K) {
            for (int i : arr) {
                System.out.print(i+" ");
            }
            return true;
        }

        return false;
    }
}