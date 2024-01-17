import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());

            while(!stk.isEmpty() && stk.peek() <= now) {
                stk.pop();
            }

            stk.push(now);
            answer += stk.size()-1;
        }

        System.out.println(answer);

    }

}