import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x;

		public Node(int x) {
			this.x = x;
		}
	}
	
	static int N, M; // 학생 수 N, 비교 수 M
	static int[] degree, count;
	static ArrayList<ArrayList<Integer>> adj;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		degree = new int[N+1];
		count = new int[N+1];
		adj = new ArrayList<>();
		
		for(int i = 0; i < N+1; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			adj.get(x).add(y);
			degree[y]++;
		}
		
		topological_sort();
		for(int i = 1; i < count.length; i++) {
			System.out.print(count[i] + " ");
		}
	}

	private static void topological_sort() {
		Queue<Node> q = new LinkedList<>();
		// q를 돌면서 진입 차수가 0인 것들을 q에 넣어준다
		for(int i = 0; i < degree.length; i++) {
			if(degree[i] == 0) {
				
				q.add(new Node(i));
			}
		}
		int idx = 0;
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int now = curr.x;
			count[idx++] = now;
			
			for(int i = 0; i < adj.get(now).size(); i++ ) {
				degree[adj.get(now).get(i)]--;
				
				if(degree[adj.get(now).get(i)] == 0) {
					q.offer(new Node(adj.get(now).get(i)));
				}
			}
		}
		
		
	}
	
}