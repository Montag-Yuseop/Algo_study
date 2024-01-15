import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int value, idx;

        // 생성자(값과 인덱스)
        public Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> dq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            while(!dq.isEmpty() && dq.getLast().value > x) dq.removeLast();


            // x 넣고, idx 채우고
            dq.addLast(new Node(x, i));

            // 범위 벗어난거 없애주고
            if(dq.getFirst().idx <= i - L) dq.removeFirst();

            sb.append(dq.getFirst().value).append(" ");


        }

        System.out.println(sb);
    }


}