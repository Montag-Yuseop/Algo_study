import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 레벨의 수
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        // 레벨 수 만큼 돌면서 각 레벨의 점수 저장
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0; // 정답 출력

        // 점수를 뒤에서부터 돌면서 앞에 더 큰 수들을 줄여준다
        for(int i = N-1; i >= 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] >= arr[i]) {
                    cnt += arr[j] - arr[i] + 1;
                    arr[j] = arr[i]-1;
                }
            }
        }

        System.out.println(cnt);

    }

}