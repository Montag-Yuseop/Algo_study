import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            hs1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            hs2.add(Integer.parseInt(st.nextToken()));
        }

        HashSet<Integer> hs12 = new HashSet<>(hs1);
        HashSet<Integer> hs21 = new HashSet<>(hs2);

        hs12.removeAll(hs2);
        hs21.removeAll(hs1);

        System.out.println(hs12.size()+hs21.size());


    }
}