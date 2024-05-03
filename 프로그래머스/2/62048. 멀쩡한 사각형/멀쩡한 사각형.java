class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        long base = (long) w * (long) h;
        
        
        long num = gcd(w, h);
        answer = base - (((w/num) + (h/num) - 1) * num);
        return answer;
    }
    
    static public long gcd(long a, long b) {
        if( b == 0) return a;
        
        return gcd(b, a%b);
        
    }
}