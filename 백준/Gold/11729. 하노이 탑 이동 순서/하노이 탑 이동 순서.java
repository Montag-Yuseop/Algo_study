import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        sb.append((int) Math.pow(2, N) - 1).append("\n");

        hanoi(N, 1, 2, 3, sb);

        System.out.println(sb);
    }

    static void hanoi(int N, int start, int mid, int end, StringBuilder sb) {
        if(N == 1) {
            sb.append(start +" " + end).append("\n");
            return;
        }

        hanoi(N-1, start, end, mid, sb);
        sb.append(start +" " + end).append("\n");
        hanoi(N-1, mid, start, end, sb);

    }
}