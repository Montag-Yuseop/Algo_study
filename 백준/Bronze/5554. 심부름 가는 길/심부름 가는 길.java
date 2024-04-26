import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int answer = Integer.parseInt(br.readLine());
        answer += Integer.parseInt(br.readLine());
        answer += Integer.parseInt(br.readLine());
        answer += Integer.parseInt(br.readLine());

        System.out.println(answer / 60);
        System.out.println(answer % 60);
    }
}