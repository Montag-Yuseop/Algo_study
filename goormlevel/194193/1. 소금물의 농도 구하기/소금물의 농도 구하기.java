import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double N = Double.parseDouble(st.nextToken());
		double M = Double.parseDouble(st.nextToken());
		
		double salt = (7 * N) / 100;
		double ans = (salt / (M + N)) * 100;
		
		String answer = String.format("%.2f", Math.floor(ans * 100) / 100.0);
		System.out.println(answer);
	}
}
