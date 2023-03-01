import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		Stack<Integer> st = new Stack<>(); // 숫자비교
		int[] arr = new int[N]; // 
		
		
		// 배열 생성
		
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
				arr[st.pop()] = arr[i];
			}
			
			st.push(i);
		}
		
		while(!st.isEmpty()) {
			arr[st.pop()] = -1;
		}
		
		for(int i = 0; i<N; i++) {
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb);
		
	}

}