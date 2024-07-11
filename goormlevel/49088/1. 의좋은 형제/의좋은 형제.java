import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 식량을 왔다갔다 나누는 문제
		// 홀수인 경우 올림으로 줘버린다
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int jinwoo = Integer.parseInt(st.nextToken());
		int seonwoo = Integer.parseInt(st.nextToken());
		
		int D = Integer.parseInt(br.readLine());
		int[] sum = {jinwoo, seonwoo};
		
		// 홀수 날에는 진우 -> 선우
		// 짝수 날에는 선우 -> 진우
		for(int i = 1; i <= D; i++) {
			// 선우가 주는 날
			
			if(i % 2 != 0) {
				carry(sum, 0, 1);
			} else {
				carry(sum, 1, 0);
			}
		}
		
		System.out.println(sum[0] +" " + sum[1]);
	}
	
	static void carry(int[] sum, int to, int from) {
		int value = (int) Math.ceil(((double) sum[to]) / 2.0);
		sum[to] -= value;
		sum[from] += value;
	}
}