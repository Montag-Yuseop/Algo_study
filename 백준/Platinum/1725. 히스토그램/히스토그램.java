import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Node> stk = new Stack();
        long answer = 0L;

        // 맨 첫 토큰은 숫자의 수
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            Node now = new Node(Integer.parseInt(br.readLine()), i);

            // 스택이 비어있지 않고, 이전 값보다 현재 값이 더 작을 때만 실행한다
            while(!stk.isEmpty() && stk.peek().value > now.value) {
                Node before = stk.pop(); // 이전 노드를 pop 한다

                int right = now.index - 1;
                int left = stk.isEmpty() ? 0 : stk.peek().index + 1;

                int width = right - left + 1;

                answer = Math.max(answer, (long) width * before.value);
            }

            stk.push(now);
        }

        while(!stk.isEmpty()) {
            Node before = stk.pop(); // 이전 노드를 pop 한다
            int right = N - 1;
            int left = stk.isEmpty() ? 0 : stk.peek().index + 1;

            int width = right - left + 1;

            answer = Math.max(answer, (long) width * before.value);

        }

        System.out.println(answer);
    }
}