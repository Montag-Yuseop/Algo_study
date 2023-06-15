import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int cnt = 1;

        // 1. 여는 괄호면 스택에 넣는다
        // 2. 닫는 괄호면 스택에서 뺀 다음 비교한다.
        // 2-1. 이 때 스택에서 꺼낸 여는 괄호와 매치되지 않으면 0을 출력하고 끝내버린다
        // 2-2. 곱하기와 더하기 처리를 해준다
        // (는 값에 곱하기 2, [는 값에 곱하기 3
        // 임시 char temp에 바로 앞의 괄호를 담아주고, 연속되는거면 더해주기, 연속이 아니면 곱해주기
        main : for(int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            char pop = ' ';

            switch (now) {
                case '(' :
                    stack.push(now);
                    cnt *= 2;
                    break;

                case '[' :
                    stack.push(now);

                    cnt *= 3;
                    break;

                case ')' :
                    if(stack.isEmpty() || stack.peek() != '('){
                        sum = 0;
                        break main;
                    }
                    pop = stack.pop();

                    if(s.charAt(i-1) == '(') {
                        sum += cnt;
                    }
                    cnt /= 2;
                    break;

                case ']' :
                    if(stack.isEmpty() || stack.peek() != '['){
                        sum = 0;
                        break main;
                    }
                    pop = stack.pop();
                    if(s.charAt(i-1) == '[') {
                        sum += cnt;
                    }
                    cnt /= 3;
                    break;
            }
        }
        if(!stack.isEmpty()) sum = 0;
        System.out.println(sum);

    }

}