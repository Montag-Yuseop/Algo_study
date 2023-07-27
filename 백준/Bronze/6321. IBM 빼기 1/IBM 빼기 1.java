import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {

            String s = br.readLine();
            String ans = "";

            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c == 'Z') {
                    ans += 'A';
                } else {
                    ans += (char) (c+1);
                }

            }

            if(i != N) {
                sb.append("String #"+i+"\n").append(ans+"\n\n");
            } else {
                sb.append("String #"+i+"\n").append(ans);
            }

        }

        System.out.println(sb);


    }

}