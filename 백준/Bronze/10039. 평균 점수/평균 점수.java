import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0 ;
		for(int i = 0 ; i < 5 ; i ++) {
			int n = Integer.parseInt(br.readLine());
			
			sum += n > 40 ? n : 40;

		}
		System.out.println(sum/5);
	}
 
}