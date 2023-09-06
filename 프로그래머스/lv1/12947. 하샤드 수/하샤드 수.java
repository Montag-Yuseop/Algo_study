class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String s = String.valueOf(x);
        int sum = 0;
        
        for(int i = 0; i < s.length(); i++) {
            sum += s.charAt(i)-'0';
        }

        answer = ((x % sum) == 0) ? true : false;
        
        return answer;
    }
}