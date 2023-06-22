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
        int[] arr = new int[N];

        // 배열 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            // 값은 필요 없음 홀 짝만 알면 된다
            arr[i] = Integer.parseInt(st.nextToken())%2;
        }

        // 앞에서부터 늘리면서 세야 할 듯
        // 뒤에서부터 하는건 줄이는 데 문제가 있음
        int start = 0;
        int end = 0;
        int leng = Integer.MIN_VALUE;
        int cnt = 0;

        while(end < arr.length) {
            if(arr[end] == 0) { // 마지막 인덱스가 짝수면?
                end++; // 한 칸 증가
                leng = Math.max(leng, end-start-cnt); // 삭제한 값만큼의 길이와 현재 길이 중 긴걸로 대체
            } else if(cnt < K) { // 삭제값보다 작으면서 짝수가 아님
                end++;
                cnt++; // 홀수 개수 증가
                leng = Math.max(leng, end-start-cnt); // 값을 다시 비교
            } else { // 끝이 홀수면서, cnt값이 K값과 같거나 더 크면?(즉 삭제 횟수가 꽉차버리면?)
                // 처음이 홀수인지 짝수인지 확인
                if(arr[start] == 1) { // 홀수면?
                    cnt--; // 하나 빼줘
                }
                start++; // 얘는 무적권 한 칸 앞으로 가
            }
        }
        System.out.println(leng);

    }
}