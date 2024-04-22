import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int val, time;

        public Node(int val, int time) {
            this.val = val;
            this.time = time;

        }
    }

    static int N, start, end;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        visited = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 출발지, 목적지
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int answer = bfs();
        System.out.println(answer);

    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        visited[start] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int num = cur.val;
            int time = cur.time;

            if(num == end) {
                return time;
            }

            for(int i = num; i > 0; i -= arr[num]) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.offer(new Node(i, time+1));
                }
            }

            for(int i = num; i < N+1; i += arr[num]) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.offer(new Node(i, time+1));
                }
            }


        }
        return -1;
    }
}