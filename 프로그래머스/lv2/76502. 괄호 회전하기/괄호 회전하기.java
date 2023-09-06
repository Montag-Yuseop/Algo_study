import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            if(check(s)) {
                answer++;
            }
            s = s.substring(1, s.length()) + s.substring(0, 1);
        }
          
         
        return answer;
    }
    
    public boolean check(String str) {
        Stack<Character> stk = new Stack();
        boolean isOk = false;
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            switch(ch) {
                case '[' :
                case '{' :
                case '(' :
                    stk.push(ch);
                    break;
                
                case ']' :
                    if(stk.isEmpty()) return false;
                    else if(stk.pop() == '[') isOk = true;
                    break;
                    
                case '}' :
                    if(stk.isEmpty()) return false;
                    else if(stk.pop() == '{') isOk = true;
                    break;
                    
                case ')' :
                    if(stk.isEmpty()) return false;
                    else if(stk.pop() == '(') isOk = true;
                    break;
            }     
        }
        if(!stk.isEmpty()) return false;
        if(isOk) return true;
        else return false;
    }
    
}