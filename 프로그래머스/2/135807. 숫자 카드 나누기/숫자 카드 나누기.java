import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        // 철수 카드는 나눌 수 있고, 영희 카드는 못나눠
        // 또는 영희 카드는 나눌수 있고, 철수 카드는 못나눠
        // 최대 공약수와 최대 공약수의 약수를 우선 구한다
        // 단 1뿐이면 0을 리턴해야 한다
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        int tempA = arrayA[0];
        int tempB = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++) {
            tempA = gcd(tempA, arrayA[i]);
            tempB = gcd(tempB, arrayB[i]);
        }
        
        if(check(arrayB, tempA)) answer = Math.max(answer, tempA);
        if(check(arrayA, tempB)) answer = Math.max(answer, tempB);
        
        return answer;
    }
    
    static boolean check(int[] array, int num) {
        for(int i : array) {
            if(i % num == 0) return false;
        }
        
        return true;
        
        
    }
    
    static int gcd(int a, int b) {
        if(b == 0) return a;
        
        return gcd(b, a%b);  
    }
    
}