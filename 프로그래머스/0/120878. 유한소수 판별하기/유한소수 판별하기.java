import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int value = gcd(a, b);
        
        a /= value;
        b /= value;
        
        if(b == 1) {
            return 1;
        }
        
        while(b % 5 == 0) {
            b /= 5;
        }
        
        while(b % 2 == 0) {
            b /= 2;
        }
        
        
        if(b != 1) {
            return 2;
        }
        
        return 1;
        
    }
    
    public int gcd(int a, int b) {
        
        while(b != 0) {
            
            int r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
}