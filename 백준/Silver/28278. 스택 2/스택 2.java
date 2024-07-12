import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    /*
    1 x : x를 스택에 삽입
    2: 스택에 정수가 있으면 빼고 출력(pop, 없으면 -1)
    3: 스택 size 출력
    4. 스택이 비어있으면 1, 아니면 0 출력
    5. 정수가 있다면 맨 위 정수 출력 peek()
    */

    int N = Integer.parseInt(br.readLine()); // 명령 N
    Stack<Integer> stk = new Stack<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int command = Integer.parseInt(st.nextToken());

      switch (command) {
        case 1:
          stk.push(Integer.parseInt(st.nextToken()));
          break;
        case 2:
          if (stk.isEmpty()) sb.append(-1);
          else sb.append(stk.pop());
          break;
        case 3:
          sb.append(stk.size());
          break;
        case 4:
          if (stk.isEmpty()) sb.append(1);
          else sb.append(0);
          break;
        case 5:
          if (stk.isEmpty()) sb.append(-1);
          else sb.append(stk.peek());
          break;
      }
      if (command != 1) sb.append("\n");
    }

    System.out.println(sb);
  }
}