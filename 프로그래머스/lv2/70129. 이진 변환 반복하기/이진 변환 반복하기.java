class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int removeZero = 0;
        int transBinary = 0;
        
        while(!s.equals("1")) {
            int temp = s.length();
            transBinary++;
            s = s.replaceAll("0", "");
            removeZero += (temp - s.length());  
            s = Integer.toBinaryString(s.length());
        }
        
        
        answer[0] = transBinary;
        answer[1] = removeZero;
        
        return answer;
    }
}