import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 세모 1, 네모 2, 동그라미 3, 별 4
		// N개의 라운드
		// 2N만큼 딱지 현황
		// A어린이, B어린이, D 무승부
		
		// 승부 규칙
		// 별 - 동그라미 - 네모 - 세모 - 무승부(4, 3, 2, 1)
		
		// 라운드 수 입력
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] peopleA = make(st);
			st = new StringTokenizer(br.readLine());
			int[] peopleB = make(st);
			
			String result = compare(peopleA, peopleB);
			sb.append(result).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	static String compare(int[] a, int[] b) {
		for(int i = 4; i > 0; i--) {
			if(a[i] > b[i]) return "A";
			else if(a[i] < b[i]) return "B";
		}
		
		return "D";
		
		
	}
	
	static int[] make(StringTokenizer st) {
		int len = Integer.parseInt(st.nextToken());
		int[] temp = new int[5];
		
		for(int i = 0; i < len; i++ ) {
			temp[Integer.parseInt(st.nextToken())]++; 
		}
		
		return temp;
	}
}