import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. N 값 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 2. 피보나치 값 만들기
        // 45까지라서 21억을 넘지 않으므로 int형으로도 커버 가능하다
        int[] arr = new int[46];

        // 3. 피보나치 초기값 설정
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 0; i < N; i++){

            // 4. 스트링 빌더에 계산 결과값 넣기
            sb.append(fibo(Integer.parseInt(br.readLine()), arr)).append("\n");
        }

        // 7. 출력
        System.out.println(sb);

    }

    public static int fibo(int n, int[] arr){
        // 5. 만약 해당 값이 있으면 바로 출력
        if(arr[n] != 0) return arr[n];

        // 6. 없으면 해당 값을 재귀로 계산
        return arr[n] = fibo(n - 1, arr) + fibo(n - 2, arr);
    }
}