import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 단어 수
        int answer = 0;

        // 테스트 수 만큼 반복
        for(int tc = 0; tc < N; tc++) {
            String s = br.readLine(); // 입력받은 단어
            Stack<Character> stk = new Stack<>();

            for(int i = 0; i < s.length(); i++) {
                char nowChar = s.charAt(i);

                if(stk.size() > 0) {
                    char beforeChar = stk.peek();

                    if(nowChar == beforeChar) stk.pop();
                    else stk.push(nowChar);
                } else {
                    stk.push(nowChar);
                }

            }

            if(stk.isEmpty()) ++answer;
        }

        System.out.println(answer);
    }




}