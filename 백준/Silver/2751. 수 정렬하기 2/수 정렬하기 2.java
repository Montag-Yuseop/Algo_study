import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(bf.readLine());
		List<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<a; i++) {
			arr.add(Integer.parseInt(bf.readLine()));
		}
		
		Collections.sort(arr);
		
		for(int list: arr) {
			bw.write(list+"\n");
		}
		bw.close();

		
		
		
	}
	
}