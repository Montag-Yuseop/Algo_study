class Solution {
    public long[] solution(long n) {
        String s = String.valueOf(n);
        long[] answer = new long[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            answer[i] = s.charAt(s.length()-1-i)-'0';
        }
        
        return answer;
    }
}