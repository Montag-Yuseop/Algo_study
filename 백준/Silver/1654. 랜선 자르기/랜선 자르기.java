import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 랜선 보유
		int N = Integer.parseInt(st.nextToken()); // 만들어야 할 개수
		
		Long[] arr = new Long[K];

		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long longLan = arr[K-1];
		long start = 1;

		while(start<=longLan) {
			long mid = (longLan+start)/2;
			long sum = 0;
			for(int i = 0; i<K; i++) {
				sum += (arr[i]/mid);
			}
			
			if(sum<N) {
				longLan = mid-1;
			} else {
				start = mid+1;
			}
			
//			System.out.println("sum: "+ sum+" start: "+ start +" longLan  "+ longLan +" mid: "+mid);
		}
		
		System.out.println(longLan);
		
	}
}