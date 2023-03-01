import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		Stack<Character> stk = new Stack<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		int cnt = 0;
		boolean check = true; // 레이저 체크용
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// (를 만나면, 레이저가 아닌상태로,
			if (c == '(') {
				stk.push(c);
				check = true;
			} else {
				stk.pop();
				if(check) {
					cnt += stk.size();
					check = false;
				} else {
					cnt++;
				}
				
			}

		}
		System.out.println(cnt);

	}

}