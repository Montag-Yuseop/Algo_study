import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long start = Math.min(a, b);
        long end = Math.max(a, b);

        if(start == end) sb.append(0);
        else {
            sb.append(end - start - 1).append("\n");

            for(long i = start + 1; i < end; i++) {
                sb.append(i + " ");
            }
        }
        
        System.out.println(sb);


    }

}