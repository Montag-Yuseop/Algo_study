import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Math.abs(Integer.parseInt(st.nextToken()));
			int Y = Math.abs(Integer.parseInt(st.nextToken()));
			int N = Math.abs(Integer.parseInt(st.nextToken()));
			
			// 홀수 짝수도 고려
			
			if(X + Y <= N) {
				if((X+Y)%2 == N%2)sb.append("YES");
				else sb.append("NO");
			}
			else sb.append("NO");
			
			if(tc < T) sb.append("\n");
			
		}
		
		
		System.out.println(sb);
	}
}