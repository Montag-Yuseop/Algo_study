import java.math.*;
import java.util.*;

class Solution {
    public BigInteger solution(int balls, int share) {
        BigInteger answer = new BigInteger("0");
        
        BigInteger value = new BigInteger("1");
        BigInteger cnt = new BigInteger("1");
        
        if(balls - share < share) {
            share = balls-share;
        }
        
        for(int i = 0; i < share; i++) {
            value = value.multiply(BigInteger.valueOf(balls - i));
        }
        
        for(int i = 1; i <= share; i++) {
            cnt = cnt.multiply(BigInteger.valueOf(i));
        }
        

        answer = value.divide(cnt);
        
    
        return answer;
    }
}