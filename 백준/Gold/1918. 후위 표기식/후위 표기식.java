import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine(); // 식 입력
        Stack<Character> stk = new Stack<>(); // 수식을 담을 stack 생성
        StringBuilder sb = new StringBuilder(); // 답을 담을 빌더 생성

        // 식의 길이만큼 진행
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // 식의 현 위치

            // 피연산자면 바로 출력에 담는다
            if(alpha(c)) sb.append(c);
            else {
                // 연산자일 경우 - 스택이 비어있으면 일단 넣는다
                if(stk.isEmpty()) stk.push(c);
                    // 스택이 차 있을 경우
                else {
                    // 스택의 top이 현재보다 우선순위가 높으면 출력한다
                    // 우선순위는 +, - | *, / | () 순이다
                    switch(c) {
                        case '+' :
                        case '-' :
                            while(!stk.isEmpty() && (stk.peek() == '+' || stk.peek() == '-' || stk.peek() == '*' || stk.peek() == '/')) {
                                sb.append(stk.pop());
                            }
                            stk.push(c);
                            break;
                        case '*' :
                        case '/' :
                            while(!stk.isEmpty() && (stk.peek() == '/' || stk.peek() == '*')){
                                char top = stk.peek();
                                if(top == '*' || top == '/') sb.append(stk.pop());
                            }
                            stk.push(c);
                            break;
                        case '(' :
                            stk.push(c);
                            break;
                        case ')' :
                            while(!stk.isEmpty() && stk.peek() != '('){
                                sb.append(stk.pop());
                            }
                            stk.pop();
                    }
                }

            }
        }

        while(!stk.isEmpty()) sb.append(stk.pop());

        System.out.println(sb);

    }

    public static boolean alpha(char c) {
        return (c >= 'A' && c <= 'Z');
    }

}