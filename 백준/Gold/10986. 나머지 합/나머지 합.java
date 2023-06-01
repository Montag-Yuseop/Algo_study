import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 길이 N
        int M = Integer.parseInt(st.nextToken()); // 나누어 떨어질 수 M
        long answer = 0; // 정답

        long[] arr = new long[N]; // 합배열
        long[] d = new long[M]; // 합 배열을 %로 나눈 나머지의 배열

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());

        // 배열에 값 입력
        for(int i = 1; i < N; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            int temp = (int) (arr[i]%M);
            if(temp == 0){
                answer++;
            }
            d[temp]++;
        }

        for(int i = 0; i < M; i++){
            if(d[i] > 1){
                answer += (d[i] * (d[i]-1)/2);
            }
        }
        
        System.out.println(answer);
    }
}