import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] tree;
	static int max=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //나무 수
		m = Integer.parseInt(st.nextToken()); // 가져가려는 나무 길이.
		
		tree = new int[n]; // 나무 높이의 합 >= m
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < n ; i ++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = max < tree[i] ? tree[i] : max ;
		}
		
		System.out.println(binarySearch());
	}
	private static int binarySearch() {
		
		int left = 0 ;
		int right = max;
		
		while(left <= right) {
			int mid = (left + right) / 2;	
			
			long length = 0 ;
			
			for(int i = 0 ; i < tree.length ; i++) {
				if(tree[i] - mid > 0 ) {
					length += (tree[i] -mid);
				}
			}
			if (m <= length) {
				left = mid + 1;
            }
            else{// m > count 
            	right = mid - 1;
            }
		}
		
		return left-1;
	}
}