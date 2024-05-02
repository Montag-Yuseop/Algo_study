import java.util.*;

class Solution {

    public long solution(String expression) {
        long max = 0;
        
        String temp = expression.replaceAll("[*\\-+]", " ");
        
        // 숫자만 담기
        String[] nums = temp.split(" ");
        
        // 연산자만 담기
        temp = expression.replaceAll("[0-9]", "");

        String[] op = temp.split("");
        
        String[][] prio = { {"*","+","-"},
                      {"*","-","+"},
                      {"+","*","-"},
                      {"+","-","*"},
                      {"-","+","*"},
                      {"-","*","+"} };
        
        // 우선순위
        for(String[] pr : prio) {
            // 연산자 리스트 생성
            ArrayList<String> opList = new ArrayList<>();
            
            // 연산자 초기화
            for(String s : op) {
                opList.add(s);
            }
            
            // 숫자 초기화
            ArrayList<Long> numList = new ArrayList<>();
            
            for(String s : nums) {
                numList.add(Long.parseLong(s));
            }
            
            // 리스트 돌면서 우선순위랑 pr 인덱스와 같으면, 해당 인덱스 제거
            for(String p : pr) {
                // 연산자 돌기
                for(int i = 0; i < opList.size(); i++) {
                    
                    // 같을 때만 계산
                    if(p.equals(opList.get(i))) {
                        long n1 = numList.get(i);
                        long n2 = numList.get(i+1);
                        
                        if(p.equals("*")) numList.add(i, n1 * n2);
                        if(p.equals("+")) numList.add(i, n1 + n2);
                        if(p.equals("-")) numList.add(i, n1 - n2);
                        
                        numList.remove(i+1);
                        numList.remove(i+1);
                        
                        // 해당 인덱스 제거
                        opList.remove(i);
                        
                        // i를 자기 위치로 다시
                        i -= 1;
                    }
                    
                }
            }
            max = Math.max(max, Math.abs(numList.get(0)));
        }
        
        
        return max;
    }
}