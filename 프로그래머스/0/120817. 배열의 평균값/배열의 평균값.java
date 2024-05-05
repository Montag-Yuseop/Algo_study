class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        
        for(int i : numbers) {
            double a = (double) i;
            
            answer += i;
        }
        
        return answer/numbers.length;
    }
}