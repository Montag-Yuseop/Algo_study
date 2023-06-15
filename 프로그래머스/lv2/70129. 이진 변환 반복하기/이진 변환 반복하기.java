class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int removeZero = 0;
        int transBinary = 0;
        
        while(!s.equals("1")) {
            
            transBinary++;
            boolean check = false;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    removeZero++;
                    check = true;
                }
            }
            s = s.replace("0", "");
            
            s = Integer.toBinaryString(s.length());
        }
        
        
        answer[0] = transBinary;
        answer[1] = removeZero;
        
        return answer;
    }
}