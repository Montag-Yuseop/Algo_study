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


        while(true) {
            String s = br.readLine();
            Set<Integer> set = new HashSet<>();

            if(s.equals("#")) {
                System.out.println(sb);
                break;
            }

            s = s.toUpperCase();
            for(int i = 0; i < s.length(); i++) {
                int c = s.charAt(i); // 65 ~ 90
                if(c >= 65 && c <= 90) {
                    set.add(c);
                }
            }

            sb.append(set.size()).append("\n");

        }
    }

}