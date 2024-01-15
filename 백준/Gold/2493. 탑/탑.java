import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int value, index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Node> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 현재 숫자보다 낮은 탑을 stack에서 모두 빼준다
            while(!stk.isEmpty() && stk.peek().value < now) stk.pop();

            // 스택이 비어있으면, 보다 높은 탑이 없는 것이므로, 0을 출력한다
            if(stk.isEmpty()) sb.append(0);
            else sb.append(stk.peek().index);

            stk.push(new Node(now, i));
            sb.append(" ");
        }

        System.out.println(sb);
    }
}