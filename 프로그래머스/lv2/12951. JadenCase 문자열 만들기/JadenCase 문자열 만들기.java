class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.toLowerCase().split(" ");
                
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].length() == 0) {
                answer += " ";
                continue;
            }
            answer += Character.toUpperCase(arr[i].charAt(0));
            answer += arr[i].substring(1);
            if(i != arr.length - 1) {
                answer += " ";
            }
            
        }
        
        answer = answer.substring(0, answer.length());
        int sub = s.length()-answer.length();
        for(int i = 0; i < sub; i++) {
            answer += " ";
        }
        
        return answer;
    }
}