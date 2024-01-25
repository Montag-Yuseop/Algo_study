import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] card;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        card = new int[21];

        for (int i = 1; i <= 20; i++) {
            card[i] = i;
        }

        for(int i = 0; i < 10; i++) {
            // 두 숫자 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 카드를 뒤집는 로직
            reverse(a, b);
        }

        br.close();

        // 출력
        for(int i = 1; i <= 20; i++) {
            sb.append(card[i]+" ");
        }

        System.out.println(sb);

    }

    public static void reverse(int a, int b) {
        // 얕은 복사와 깊은 복사
        // 그냥 할당하면 얕은 복사 - int[] copy = card; = 주소값 공유로 인해 값이 바뀌면 같이 바뀜
        // clone을 통한 깊은 복사 - 값만 공유하기 때문에 서로 개별적인 메모리에 담긴다
        int[] copy = card.clone();

        // 5, 10이면 5 - 10, 6 - 9 ...
        for(int i = a; i <= b; i++) {
            card[i] = copy[b-i+a];
        }

    }

}