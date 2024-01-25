import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static class Node {
        int value, count;

        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Node> stk = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        long answer = 0;

        for(int i = 0 ; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            Node next = new Node(now, 1);

            while(!stk.isEmpty() && stk.peek().value <= now) {
                Node before = stk.pop();
                answer += before.count;
                if(before.value == now) next.count += before.count;
            }
            if(!stk.isEmpty()) ++answer;
            stk.push(next);
        }

        System.out.println(answer);
    }
}