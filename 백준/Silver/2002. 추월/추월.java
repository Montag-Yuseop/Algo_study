import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> in = new HashMap<>();
//        Map<String, Integer> out = new HashMap<>();


        int N = sc.nextInt();
        int ans = 0; // 정답 출력
        int[] out = new int[N+1];

        for(int i = 1; i < N+1; i++) {
            in.put(sc.next(), i);
        }

        for(int i = 1; i < N+1; i++) {
            String s = sc.next();
            out[i] = in.get(s);
        }

        for(int i = 1; i < N; i++) {
            for(int j = i+1; j < N+1; j++) {
                if(out[i] > out[j]) {
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);

    }
}