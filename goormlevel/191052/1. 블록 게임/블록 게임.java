import java.io.*;
import java.util.*;

class Main {
	static class Node{
		int r, c;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String command = br.readLine();
		
		int[][] blocks = new int[2*N+1][2*N+1];
		int nowR = N;
		int nowC = N;
		blocks[nowR][nowC] = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] score = new int[N]; // 점수 저장
		Stack<Node> location = new Stack<>();
		location.push(new Node(nowR, nowC));
		
		for(int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이동 방향
		int[] dr = {0, 0, -1, 1};
		int[] dc = {-1, 1, 0, 0};
		
		int ans = 1;
		// 명령 진행
		for(int i = 0; i < command.length(); i++) {
			char c = command.charAt(i);
			int dir = 0;
			if(c == 'L') dir = 0;
			else if(c == 'R') dir = 1;
			else if(c == 'U') dir = 2;
			else dir = 3;
			
			Node cur = location.peek();
			nowR = cur.r;
			nowC = cur.c;
			
			int nextR = cur.r + dr[dir];
			int nextC = cur.c + dc[dir];
			
			if(blocks[nextR][nextC] == 0) {
				blocks[nextR][nextC] = score[i];
				ans += score[i];
			} else {
				while(!location.isEmpty()) {
					Node temp = location.pop();
					
					if(temp.r == nextR && temp.c == nextC) {
						ans -= blocks[temp.r][temp.c];
						
						blocks[nextR][nextC] = score[i];
						
						ans += score[i];
						break;
					}
					ans -= blocks[temp.r][temp.c];
					blocks[temp.r][temp.c] = 0;
				}
			}
			
			location.push(new Node(nextR, nextC));
			
		}
		// for(int i = 0; i < 2*N+1; i++) {
		// 	System.out.println(Arrays.toString(blocks[i]));
		// }
		// System.out.println();
		System.out.println(ans);
	}
}