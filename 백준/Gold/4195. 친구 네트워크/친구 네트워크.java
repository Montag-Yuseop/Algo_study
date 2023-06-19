import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static HashMap<String, Integer> map;
    static int[] parent;
    static int[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb= new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine()); // 친구 수
            map = new HashMap<>();
            parent = new int[N * 2 + 1];
            for(int i = 1; i <= N*2; i++) {
                parent[i] = i;
            }
            count = new int[N * 2 + 1];
            Arrays.fill(count, 1);

            int idx = 1;
            for(int i = 0; i < N; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(!map.containsKey(a)) {
                    map.put(a, idx++);
                }
                if(!map.containsKey(b)) {
                    map.put(b, idx++);
                }
//                System.out.println(Arrays.toString(parent));

                union(map.get(a), map.get(b));
//
//                System.out.println(map);
//                System.out.println(Arrays.toString(parent));
//                System.out.println(Arrays.toString(count));

                int min = Math.min(map.get(a), map.get(b));
//                System.out.println(min);
                sb.append(count[find(min)]+"\n");

            }

        }
        System.out.println(sb);

    }
    public static void union(int a, int b) {
        a = find(parent[a]);
        b = find(parent[b]);
        if(a == b) return;
        if(a != b) {
            parent[b] = a;
            count[a] += count[b];
        }

    }

    public static int find(int a) {
        if(parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}