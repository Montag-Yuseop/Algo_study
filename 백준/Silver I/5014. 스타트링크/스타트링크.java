import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node{
        int index, count;

        public Node(int index, int count){
            this.index = index;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {

        // 총 몇 층, 스타트링크 G 층, 강호 S층, U는 업, D는 다운 몇 층씩

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] map = new int[F + 1];

        int[] button = {U, -D};

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(S, 0));
        map[S] = 0;
        int answer = -1;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int now = cur.index;
            int cnt = cur.count;

            if(now == G) {
                answer = map[G];
                break;
            }

            for(int i = 0; i < 2; i++) {
                int next = now + button[i];
                if(next > 0 && next < F + 1 && map[next] == 0) {
                    map[next] = cnt + 1;
                    q.offer(new Node(next, cnt+1));
                }
            }
        }

        if(answer == -1) System.out.println("use the stairs");
        else System.out.println(map[G]);

    }
}