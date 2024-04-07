class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            
            long num = numbers[i];
            
            if(num % 2 == 0) answer[i] = num + 1;
            
            else {
                StringBuilder s = new StringBuilder(Long.toBinaryString(num));
                int len = s.length();
                
                if(s.toString().contains("01")) {
                    for(int j = len; j > 0; j--) {
                        if(s.substring(j-2, j).equals("01")) {
                            s.setCharAt(j-1, '0');
                            s.setCharAt(j-2, '1');
                            break;
                        }
                        
                    }
                    
                } else {
                    s.deleteCharAt(0);
                    s.insert(0, "10");
                }
                answer[i] = Long.valueOf(s.toString(), 2);
            }
            
            

        }        
        return answer;
    }
}