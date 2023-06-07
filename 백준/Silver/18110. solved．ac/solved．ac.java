import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        double sum = 0;

        for(int i = 0; i< N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 배열 정렬
        Arrays.sort(arr);

        int x = (int) Math.round(N * 0.15); // 상위 15%, 하위 15%

        for(int i = x; i < arr.length - x; i++){
           sum += arr[i];
        }

        System.out.println((int) Math.round(sum/(arr.length-(2*x))));
    }
}