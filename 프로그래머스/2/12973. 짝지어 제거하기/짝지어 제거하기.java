import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack();
        char[] charArr = s.toCharArray();
        
        for(int i = 0; i < charArr.length; i++) {
            // stack이 비어있으면 그냥 넣으면 된다(빈 값 처리를 해줘야 한다)
            if(stack.isEmpty()) stack.push(charArr[i]);
            // stack의 전 단어가 동일하다면? 안넣어고 전 것도 뺀다
            else if(stack.peek() == charArr[i]) stack.pop();
            // 다른 경우에는 그냥 넣는다
            else stack.push(charArr[i]);
        }
        
        // stack이 비어있으면 모두 빠진 것이므로 가능한 상황
        if(stack.size() == 0) return 1; 
        return answer;
    }
}