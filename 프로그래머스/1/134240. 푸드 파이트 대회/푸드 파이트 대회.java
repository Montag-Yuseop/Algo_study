class Solution {
    public String solution(int[] food) {
        String answer = "0";
        
        for(int i = food.length - 1; i >= 1; i--) {
            int r = food[i] / 2;
            
            for(int j = 0; j < r; j++) {
                answer = String.valueOf(i) + answer + String.valueOf(i);
            }
            
        }
        
        return answer;
    }
}