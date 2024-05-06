import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while((str = br.readLine()) != null) {
            sb.append(str);
            sb.append("\n");
//            System.out.println(str);
        }

        System.out.println(sb);
    }
}