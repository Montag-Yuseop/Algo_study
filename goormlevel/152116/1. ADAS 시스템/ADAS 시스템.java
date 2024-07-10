import java.io.*;
import java.util.*;

class Main {
	static class Node{
		int r, c, v, type;
		
		public Node(int r, int c, int v, int type) {
			this.r = r;
			this.c = c;
			this.v = v;
			this.type = type;
		}
	}
	
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int answer = Integer.MAX_VALUE;
	static int[] dr = {0, 0, -1, 1, 1, 1, -1, -1}; // 0 ~ 3까지는 4방향, 4 ~ 7 대각방향
	static int[] dc = {-1, 1, 0, 0, 1, -1, -1, 1}; // 이동은 4방향, 탐색은 8방향
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		int startR = 0;
		int startC = 0;
		
		for(int r = 0; r < N; r++) {
			String s = br.readLine();
			for(int c = 0; c < M; c++) {
				char ch = s.charAt(c);
				map[r][c] = ch;
				if(ch == 'S') {
					startR = r;
					startC = c;
				}
			}
		}
		
		int answer = bfs(startR, startC);
		System.out.println(Math.max(0, answer));
	}
	
	static int bfs(int startR, int startC) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
			if(o1.type == o2.type) {
				if(o1.r == o2.r) {
					return o1.c - o2.c;
				}
				return o1.r - o2.r;
			}
			return o1.type - o2.type;
			});
		// S = 0, E = 1, P = 2, 0 = 3;
		pq.offer(new Node(startR, startC, 0, 0));
		visited[startR][startC] = true;
		int sum = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll(); // 현재 노드 가져오기
			
			int nowR = cur.r;
			int nowC = cur.c;
			sum += cur.v;
			
			if(map[nowR][nowC] == 'E') {
				return sum;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = nowR + dr[d];
				int nc = nowC + dc[d];
				
				
				if(bc(nr, nc) && !visited[nr][nc]) {
					int cnt = 0;
					for(int i = 0; i < 8; i++) {
						if(bc(nr+dr[i], nc + dc[i]) && map[nr+dr[i]][nc+dc[i]] == 'P') cnt++;
					}
					Node next;
					if(map[nr][nc] == 'E') {
						cnt = 0;
						next = new Node(nr, nc, cnt, 1);
					} else if(map[nr][nc] == 'P') {
						cnt -= 3;
						next = new Node(nr, nc, cnt, 2);
					} else {
						next = new Node(nr, nc, cnt, 3);
					}
					pq.offer(next);
					visited[nr][nc] = true;
				}
				
			}
			
		}
		
		return -1;
	}
	
	static boolean bc(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}