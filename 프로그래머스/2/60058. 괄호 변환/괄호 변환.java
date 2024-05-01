import java.util.*;

class Solution {
    public String solution(String p) {
        
        if(p.length() == 0) return "";
        
        if(isCorrect(p)) return p;
        
        // 균형잡힌 괄호 문자열 u, v로 분리해서 결과값 내기
        return find(p);

    }
    
    static String find(String p) {
        // 쪼갤게 안남았으면 빈 문자열 반환
        if(p.length() == 0) return "";
        
        String u = "";
        String v = "";
        
        int open = 0;
        int close = 0;
        
        for(int i = 0; i < p.length(); i++) {
            // p의 길이만큼 가면서, open close 값이 같아질 때 쪼개기
            char c = p.charAt(i);
            
            if(c == ')') close++;
            else open++;
            
            // 값이 0이 아니고, 괄호 값이 같아질 때 i값을 기준으로 분리
            if((open > 0 && close > 0) && (open == close)) {
                u = p.substring(0, i+1);
                
                // (), (()) 같은 경우에 오류 뜰거 방지
                if(i + 1 < p.length()) v = p.substring(i+1, p.length());
                break;
            }
            
        }
        
        // 3번
        if(isCorrect(u)) return u + find(v);
        
        // 4번
        else {
            String temp = "("; // 4-1
            temp += find(v) + ")"; // 4-2 + 4-3
            u = u.substring(1, u.length() - 1);
            
            u = u.replace("(", ".");
            u = u.replace(")", "(");
            u = u.replace(".", ")");
            
            u = temp + u;
            return u;
        }
    }
    
    static boolean isCorrect(String p) {
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            
            if(c == '(') stk.push(c);
            else {
                if(stk.isEmpty() || stk.peek() == c) return false;        
                stk.pop();
            }
            
        }
        if(!stk.isEmpty()) return false;
        return true;
    }
}