class Solution {
    public String solution(String s) {
        String answer = "";
        
        int x = s.length();
        
        if(x%2 == 0) {
            answer = s.substring(x/2-1, x/2+1);
        } else {
            answer = s.substring(x/2, x/2+1);
        }
        
        return answer;
    }
}