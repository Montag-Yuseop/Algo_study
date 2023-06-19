import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] parent;

    public static void main(String[] args) throws IOException {

        // 학생 수 N
        // 친구 관계 수 M
        // 가진 돈 k

        // N개 - 학생이 원하는 친구비
        // M번 - 친구 관계 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int[] cost = new int[N+1]; // 친구비용 저장
        int ans = 0; // 정답 출력

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b, cost);
        }

       for(int i = 1; i < cost.length; i++) {
           if(parent[i] == i) {
               ans += cost[i];
           }
       }


//        System.out.println(Arrays.toString(parent));
//        System.out.println(Arrays.toString(cost));

        if(money- ans >= 0) {
            System.out.println(ans);
        } else {
            System.out.println("Oh no");
        }

    }
    public static void union(int a, int b, int[] cost) {
        a = find(a);
        b = find(b);

        if(a != b) {
            if(cost[a] > cost[b]) {
                parent[a] = b;
            } else {
                parent[b] = a;
            }
        }
    }

    public static int find(int a) {
        if(a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}