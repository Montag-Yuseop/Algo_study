import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		outer: for(int i=2; i<=N; ) {
			if(N%i == 0) {
				N = N/i;
				System.out.println(i);
				continue outer;
			} else {
				i++;
			}
			
			
		}
		

	}

}