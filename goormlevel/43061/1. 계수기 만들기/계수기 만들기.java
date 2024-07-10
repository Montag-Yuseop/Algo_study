import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자릿수 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 각 자릿수의 최댓값 입력 받기
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 숫자 입력 받기
        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // K 입력 받기
        int K = Integer.parseInt(br.readLine().trim());

        // 초기 숫자 배열을 복사하여 현재 숫자 배열 초기화
        int[] currentNumber = new int[N];
        System.arraycopy(B, 0, currentNumber, 0, N);

        // K번 더하기
        for (int k = 0; k < K; k++) {
            // 현재 자릿수에서부터 처리
            for (int i = N - 1; i >= 0; i--) {
                currentNumber[i]++; // 현재 자릿수에 1을 더함

                // 만약 현재 자릿수가 최댓값을 넘어가면 다음 자릿수로 넘어감
                if (currentNumber[i] > A[i]) {
                    currentNumber[i] = 0; // 현재 자릿수 초기화
                } else {
                    break; // 올림이 발생하지 않으면 반복 종료
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(currentNumber[i]);
        }
        System.out.println(sb.toString());
    }
}