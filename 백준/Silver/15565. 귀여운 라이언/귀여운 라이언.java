import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[N]; // 인덱스 저장
        int min = Integer.MAX_VALUE;
        int count = 0;

        // 꿀귀 라이언, 꿀귀 어피치 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == 1) {
                list.add(i);
                count++; // 라이언 인형의 개수를 세어준다
            }
        }

        if(count < K) { // 만약 개수가 K보다 작으면 그런 집합은 존재할 수 없다
            System.out.println(-1);
        } else {
            // list에 0, 4, 6, 9 저장
            for(int i = 0; i < list.size()-K+1; i++) {
                int start = list.get(i);
                int end = list.get(i+K-1);
                min = Math.min(min, end-start);
            }

            System.out.println(min+1);

        }




    }
}