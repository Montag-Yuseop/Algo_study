import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 개발자의 수
        int[] arr = new int[N]; // 개발자 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;
        int start = 0;
        int end = arr.length-1;

        while(start < end) {
            int min = Math.min(arr[start], arr[end]);
            int len = end - start - 1;
            answer = Math.max(min * len, answer); // 정답은 더 큰 애
//            System.out.println(min +" "+len + " "+answer);
            if(arr[start] <= arr[end]) {
                start++;
            } else {
                end--;
            }

        }
        System.out.println(answer);

    }
}