import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);
	
	public static void testCase(int caseIndex) {
		int N = scanner.nextInt();  // 지도의 크기 
		int K = scanner.nextInt();  // 놀이공원의 크기
		int answer = Integer.MAX_VALUE;
		
		int[][] wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부 
		for (int r = 0; r < N; r += 1) {
			for (int c = 0; c < N; c += 1) {
				wastes[r][c] = scanner.nextInt();
			}
		}
		
		for(int r = 0; r < N - K + 1; r += 1) {
			for(int c = 0; c < N - K + 1; c += 1) {
				
				int cnt = 0;
				outer: for(int i = r; i < r + K; i += 1) {
					for(int j = c; j < c + K; j += 1) {
						cnt += wastes[i][j];
						if(cnt >= answer) break outer;
					}
				}
				answer = Math.min(answer, cnt);
			}
		}
		
		
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();
		
		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
		
	}
	
}