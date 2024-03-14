class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 0; i < arr.length; i++) {
            int gcd = gcd(answer, arr[i]);
            answer = (answer * arr[i]) / gcd(answer, arr[i]);
        }
        
        return answer;
    }
    
    // 최대 공약수
    public int gcd(int a, int b) {
        
        while(b != 0) {
            int r = a % b; // 나머지
            
            a = b;
            b = r;
        }
        
        return a;
    }
    
    // 최소 공배수
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}