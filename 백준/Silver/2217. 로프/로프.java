import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];

		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rope);
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			max = Math.max(max, rope[i] * (N - i));
		}

		bw.write(max + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

}