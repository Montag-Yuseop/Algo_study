import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int index, time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", time=" + time +
                    '}';
        }
    }

    static int N, K, answer;
    static int[] map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        K = Integer.parseInt(st.nextToken()); // 동생의 위치
        map = new int[100001];

        bfs();

        System.out.print(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>(); // 위치를 넣을 queue 생성
        int[] visited = new int[100001];
        int[] before = new int[100001];
        q.offer(N); // 시작 위치를 q에 집어 넣는다
        visited[N] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();
            if(now - 1 >= 0 && visited[now - 1] == 0) {
                visited[now - 1] = visited[now] + 1;
                before[now - 1] = now;
                q.offer(now - 1);
            }

            if(now + 1 <= 100000 && visited[now + 1] == 0) {
                visited[now + 1] = visited[now] + 1;
                before[now + 1] = now;
                q.offer(now + 1);
            }

            if(now * 2 <= 100000 && visited[2 * now] == 0) {
                visited[2 * now] = visited[now] + 1;
                before[2 * now] = now;
                q.offer(2 * now);
            }

            if(visited[K] != 0) {
                int index = K;
                sb.append(K);
                while(index != N) {
                    sb.insert(0, before[index] + " ");
                    index = before[index];
                }
                sb.insert(0, "\n").insert(0, visited[K]-1);
                return;
            }

        }



    }


}