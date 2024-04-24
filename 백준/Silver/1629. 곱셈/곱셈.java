import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    public static long pow(long a, long b, long c) {
        // a는 밑
        // b는 지수
        // c는 나눌 수

        if(b == 1) return a % c;
        long temp = pow(a, b/2, c);
        // 지수가 홀수일 경우
        if(b%2 == 1) return temp * temp % c * a % c;

        // 짝수일 경우
        return temp * temp % c;
    }
}