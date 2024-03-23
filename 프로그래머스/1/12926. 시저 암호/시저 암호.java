class Solution {
    public String solution(String s, int n) {
        String answer = "";
        // 17 ~ 42
        // 49 ~ 74
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c - '0' >= 17 && c - '0' <= 42) {
                int x = c - '0' + n;
                if(x > 42) {
                    x -= 26;
                }
                answer += (char) (x + '0');
                
            } else if(c - '0' >= 49 && c - '0' <= 74) {
                int x = c - '0' + n;
                if(x > 74) {
                    x -= 26;
                }
                answer += (char) (x + '0');
                
            } else {
                answer += c;
            }
            
            
            
        }
        
        return answer;
    }
}