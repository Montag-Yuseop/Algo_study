import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 10000 이하 자연수, N은 10 ~ 10만
        // 연속된 수들의 부분합 중
        // 합이 S 이상이면서 길이가 가장 짧은...?
        // 불가능하면 0

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int minLength = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int sum = 0;
        while(end < arr.length && start <= end) {
            sum += arr[end]; // 끝 값만 더해주기
//            System.out.println(sum);

            if(sum >= S) { // sum이 S 이상이면
                // 길이 저장 포인터값 조절
                minLength = Math.min(minLength, end-start+1);
                sum -= arr[start];
                start++;
                sum -= arr[end];
            } else {
                end++;
            }

//            System.out.println("start: " + start + " end: " + end + " sum: " + sum);

        }

        if(minLength == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLength);
        }



    }
}