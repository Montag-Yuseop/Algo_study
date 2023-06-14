class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++ ) {
            min = Math.min(min, Long.parseLong(arr[i]));
            max = Math.max(max, Long.parseLong(arr[i]));
        }
        
        answer = min +" "+max;
        
        return answer;
    }
}