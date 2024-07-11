import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 1;
		if(N == 0) answer = 1;
		else {
			for(int i = 1; i <= N; i++) {
				int temp = i * answer;
				
				while(temp >= 10) {
					int v = temp / 10;
					int r = temp % 10;
					temp = v + r;
				}
				answer = temp;
			}
		}
		
		System.out.println(answer);
	}
}