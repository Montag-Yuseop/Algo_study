import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 입력 자체가 오름차순

        int start = 0;
        int end = arr.length-1;
        int l = 0;
        int r = 0;
        while(start < end) {
            int temp = arr[start] + arr[end];

            min = Math.min(min, Math.abs(temp));
            if(Math.abs(temp) == min) {
                l = arr[start];
                r = arr[end];
            }
            if(temp < 0) {
                start++;
            } else if(temp >= 0) {
                end--;
            }
        }

        System.out.println(l+" "+r);

    }
}