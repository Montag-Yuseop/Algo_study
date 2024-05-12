import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<n;i++){
            sb.append(i+1).append(" ");
            if((i+1) % 6 == 0 || i == n-1){
                sb.append("Go! ");
            }
        }
        System.out.println(sb);
    }
}