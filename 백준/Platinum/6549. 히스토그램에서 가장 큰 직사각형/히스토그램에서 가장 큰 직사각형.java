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
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<Node> stk = new Stack();
            long answer = 0L;

            // 맨 첫 토큰은 숫자의 수
            int N = Integer.parseInt(st.nextToken());

            // 종료 조건
            if(N == 0) break;


            for(int i = 0; i < N; i++) {
                Node now = new Node(Integer.parseInt(st.nextToken()), i);
//                System.out.println("now.value = " + now.value);

                // 스택이 비어있지 않고, 이전 값보다 현재 값이 더 작을 때만 실행한다
                while(!stk.isEmpty() && stk.peek().value > now.value) {
                    Node before = stk.pop(); // 이전 노드를 pop 한다
//                    System.out.println("before.value = " + before.value);
//                    System.out.println("before.index = " + before.index);

                    int right = now.index - 1;
                    int left = stk.isEmpty() ? 0  : stk.peek().index + 1;

//                    System.out.println("left = " + left + " right = " + right);

                    int width = right - left + 1;

                    answer = Math.max(answer, (long) width * before.value);
//                    System.out.println("answer = " + answer);
                }

                stk.push(now);
            }

//            System.out.println("=======확인==========");
            while(!stk.isEmpty()) {
                Node before = stk.pop(); // 이전 노드를 pop 한다
                int right = N - 1;
                int left = stk.isEmpty() ? 0 : stk.peek().index + 1;

//                System.out.println("before.value = " + before.value);
//                System.out.println("before.index = " + before.index);
//                System.out.println("left = " + left + " right = " + right);

                int width = right - left + 1;

                answer = Math.max(answer, (long) width * before.value);
//                System.out.println("answer = " + answer);

            }
//            System.out.println("answer = " + answer);

            sb.append(answer).append("\n");

        }

        System.out.println(sb);

    }

}