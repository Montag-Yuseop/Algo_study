import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] antList = new int[N];
		
		for(int i = 0 ; i < N; i++) {
			antList[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(antList);
		
		int left = 0;
		int right = 0;
		int answer = 0; // 정답 출력, 최솟값
		
		// 이분 탐색 시작
		while(left < N && right < N) {
			int firstAnt = antList[left];
			int lastAnt = antList[right];
			int count = lastAnt - firstAnt;
			int antSum = right - left + 1;
			
			if(count <= len) {
				answer = Math.max(answer, antSum);
				right++;
			} else if(count > len) {
				left++;
			} 
		}
		// 1 2 4
		System.out.println(N - answer);
	}
}