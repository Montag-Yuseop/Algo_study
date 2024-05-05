class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        
        double a = (double) num1 / (double) num2 * 1000;
        
        return (int) Math.floor(a);
    }
}