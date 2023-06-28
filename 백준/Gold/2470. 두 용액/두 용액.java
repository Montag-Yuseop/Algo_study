import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // arr size = N만큼 조정
        int[] arr = new int[N];

        // 입력 자체가 오름차순이므로, 정렬 없이 그냥 배열에 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE; // 최소인 값을 비교할 변수
        int start = 0; // 시작
        int end = arr.length-1; // 끝값
        int l = 0; // 이건 답 출력할 왼쪽 index
        int r = 0; // 얘는 오른쪽

        // 반복문 시작
        while(start < end) {
            int temp = arr[start] + arr[end]; // 두 용액을 더한 값
            min = Math.min(min, Math.abs(temp)); // min값 조절, 절댓값으로 비교

            // 만일 절댓값이 min값과 같다면 계속해서 l과 r값을 변경
            if(Math.abs(temp) == min) {
                l = arr[start];
                r = arr[end];
            }
            // 만일 두 용액을 더한 값이 음수면?
            // 음수부분이 꽤 큰거니까, 음수를 줄여주자
            if(temp < 0) {
                start++;
            }
            // 만일 더한 값이 양수면 끝값을 줄여주자, 근데 0이면 탈출해도 되잖아?
            else if(temp > 0) {
                end--;
            }
            // 탈출부분 작성해봄 => 하지만 시간과 메모리 큰 차이 없었다고 한다..
            // 왜냐면? 생각해보면 0이 되는 경우는 거의 중간에서 만날쯤 아닐까?
            // -1 1 99 100 101 이런 경우도
            // 계속 양수니까 end부분만 계속 줄어들고...
            // 결국 1번 내지 2번 정도의 차이 아닐까?
            if(temp == 0){
                break;
            }
        }

        System.out.println(l+" "+r);

    }
}