import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < T; tc++) {
			// treemap이라는 구조를 이용해야 함, getfirst, getlast를 사용해서 앞뒤로 뺄 수 있음
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int N = Integer.parseInt(br.readLine());
			
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = 0;
				switch(st.nextToken()) {
				case "I" :
					x = Integer.parseInt(st.nextToken());
					map.put(x, map.getOrDefault(x, 0)+1);
					
					break;
				
				case "D" :
					x = Integer.parseInt(st.nextToken());
					if(map.isEmpty()) {
						continue;
					} else if(x == 1) {
						map.put(map.lastKey(), map.get(map.lastKey())-1);
						if(map.get(map.lastKey()) == 0) {
							map.remove(map.lastKey());
						}
						
					} else {
						map.put(map.firstKey(), map.get(map.firstKey())-1);
						if(map.get(map.firstKey()) == 0) {
							map.remove(map.firstKey());
						}
					}
					

					break;
				}
				
			}
			if(map.size() ==0 ) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()+" "+map.firstKey()+"\n");
			}
			
		}
		System.out.println(sb);
		
	}
}