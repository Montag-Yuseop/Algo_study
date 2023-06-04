import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> hs1 = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N; i++){
            String s = br.readLine();
            hs1.add(s);
        }

        for(int i = 0; i < M; i++){
            String s = br.readLine();
            if(hs1.contains(s)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}