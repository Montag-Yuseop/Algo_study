import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 집의 개수
		int M = Integer.parseInt(st.nextToken()); // 장마 기간
		
		int[] arr = new int[N];
		
		// 배열 초기화
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] copy = arr.clone(); // 3일마다 비교할 배열
		
		// M개의 줄
		for(int i = 0; i < M; i++) {
			// si ~ ei까지 비가 내렸다는 의미
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr = rain(arr, start, end);
			
			// 3의 배수가 되는 날
			if((i+1)%3 == 0) {
				arr = sink(arr, copy);
				copy = arr.clone();
			}
		}
		
		for(int i : arr) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
	
	// 땅 높이 증가시키는 메서드
	static int[] rain(int[] arr, int start, int end) {
		for(int i = start-1; i < end; i++) {
			arr[i] += 1;
		}
		return arr;
	}
	
	// 물 빼는 함수
	 static int[] sink(int[] arr, int[] copy) {
		 for(int i = 0; i < arr.length; i++) {
			 if(arr[i] != copy[i]) arr[i] -= 1;
		 }
		 
		 return arr;
	 }
	
}