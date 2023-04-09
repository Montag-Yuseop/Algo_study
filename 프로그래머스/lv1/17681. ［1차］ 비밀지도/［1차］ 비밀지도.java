class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            String num1 = Long.toBinaryString(arr1[i]);
            String num2 = Long.toBinaryString(arr2[i]);
            num1 = String.format("%0"+n+"d", Long.parseLong(num1));
            num2 = String.format("%0"+n+"d", Long.parseLong(num2));
            
            String s = "";
            for(int j = 0; j < n; j++){
                int x = num1.charAt(j) - '0';
                int y = num2.charAt(j) - '0';
                
                if((x|y) == 1) {
                    s += "#";
                } else{
                    s += " ";
                } 
            }
            answer[i] = s;
        }
        
        
        return answer;
    }
}