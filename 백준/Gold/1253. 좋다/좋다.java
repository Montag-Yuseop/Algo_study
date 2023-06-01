import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int answer = 0; // 정답 수 올리기
        long[] arr = new long[N]; // long형으로 선언
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
           arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            long find = arr[i];
            int start = 0;
            int end = N-1;

            while(start < end){
                if(arr[start]+arr[end] == find){
                    if(start != i && end != i){
                        answer++;
                        break;
                    } else if(start == i){
                        start++;
                    } else if(end == i){
                        end--;
                    }
                } else if(arr[start]+arr[end] < find){
                    start++;
                } else{
                    end--;
                }
            }
        }
        System.out.println(answer);

    }
}