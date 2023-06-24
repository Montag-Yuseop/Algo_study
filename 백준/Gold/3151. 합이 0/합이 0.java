import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 3명으로 구성
        // -10000 ~ 10000
        // 코딩 실력 합이 0이 되도록
        // 반복문 + 투포인터?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for(int i = 0; i < N-2; i++) {
            int start = i+1; // 시작은 앞에서부터
            int end = N-1; // 앞에서부터 가면 브루트포스와 다를 바 없으니까, 뒤에서 부터 해보자
            while(start < end) {
                int l = 1;
                int r = 1;

                if(arr[i] > 0) break; // 어차피 맨 앞 값이 가장 크면 비교불가
                int temp = arr[i] + arr[start] + arr[end];
                if(temp == 0) {
                    if(arr[start] == arr[end]) {
                        ans += (end - start + 1) * (end - start) / 2;
                        break;
                    }
                    while(start + 1 < end && arr[start] == arr[start+1]) {
                        l++;
                        start++;
                    }
                    while(start < end-1 && arr[end] == arr[end-1]) {
                        r++;
                        end--;
                    }
                    ans += l*r;
                }
                if(temp > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        System.out.println(ans);


    }
}