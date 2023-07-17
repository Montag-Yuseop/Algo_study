import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 5; i++) {
            if(Integer.parseInt(st.nextToken()) == N) {
                ans++;
            }
        }

        System.out.println(ans);

    }

}