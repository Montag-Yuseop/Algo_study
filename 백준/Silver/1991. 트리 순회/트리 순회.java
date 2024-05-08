import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        String self;
        Node left, right;

        public Node(String self, Node left, Node right) {
            this.self = self;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "self='" + self + '\'' +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static Node head = new Node("A", null, null);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();

            insert(head, a, b, c);
        }

        preOrder(head);
        sb.append("\n");
        inOrder(head);
        sb.append("\n");
        postOrder(head);

        System.out.println(sb);
    }

    static void preOrder(Node now) {
        if(now == null) return;
        sb.append(now.self);
        preOrder(now.left);
        preOrder(now.right);
    }

    static void inOrder(Node now) {
        if(now == null) return;
        inOrder(now.left);
        sb.append(now.self);
        inOrder(now.right);
    }

    static void postOrder(Node now) {
        if(now == null) return;
        postOrder(now.left);
        postOrder(now.right);
        sb.append(now.self);
    }

    static void insert(Node now, String value, String left, String right) {

        if(now.self.equals(value)) {
            now.left = left.equals(".") ? null : new Node(left, null, null);
            now.right = right.equals(".") ? null : new Node(right, null, null);
        } else {
            if(now.left != null) insert(now.left, value, left, right);
            if(now.right != null) insert(now.right, value, left, right);
        }
    }
}