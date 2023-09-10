class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int x = phone_number.length()-4;
        for(int i = 0; i < x; i++) {
            answer += "*";
        }
        
        answer += phone_number.substring(x);
        
        return answer;
    }
}