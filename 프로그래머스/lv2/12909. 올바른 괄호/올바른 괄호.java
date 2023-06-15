import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(' :
                    if(i == s.length()-1) {
                        answer = false;
                        break;
                    } 
                    st.push(c);
                    break;
                case ')' :
                    if(st.isEmpty()) {
                        answer = false;
                        break;
                    }
                    char temp = st.pop();
                    if(temp != '(') {
                        answer = false;
                        break;
                    }
                    break;
            }    
        }
        if(!st.isEmpty()){
                answer = false;
            }
        
        return answer;
    }
}