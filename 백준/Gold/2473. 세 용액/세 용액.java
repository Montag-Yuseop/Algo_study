import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // arr size = N만큼 조정
        long[] arr = new long[N];

        // 입력 자체가 오름차순이므로, 정렬 없이 그냥 배열에 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE; // 최소인 값을 비교할 변수
        long[] ans = new long[3];
        for(int i = 0; i < N-2; i++) {

            int start = i+1; // 시작
            int end = arr.length - 1; // 끝값
            // 반복문 시작
            while (start < end) {
                long sum = arr[i] + arr[start] + arr[end];
                long temp = Math.abs(sum);

                // 만일 절댓값이 min값과 같다면 계속해서 l과 r값을 변경
                if (temp < min) {
                    min = temp;
                    ans[0] = arr[i];
                    ans[1] = arr[start];
                    ans[2] = arr[end];
                }
                // 만일 두 용액을 더한 값이 음수면?
                // 음수부분이 꽤 큰거니까, 음수를 줄여주자

                if (sum > 0) {
                    end--;
                }
                else {
                    start++;
                }
                if (temp == 0) {
                    break;
                }
            }
        }

        Arrays.sort(ans);
        for(int i = 0; i < 3; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}