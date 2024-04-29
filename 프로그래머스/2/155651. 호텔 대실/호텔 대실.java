class Solution {
    
    static final int MAX = 1450; // 막날 + 청소담게 + 10
    static final int HOUR = 60;
    static final int CLEAN = 10;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] hotel = new int[MAX];
        
        for(String[] time : book_time) {
            int inHour = Integer.parseInt(time[0].split(":")[0]);
            int inMin = Integer.parseInt(time[0].split(":")[1]);
            int inTime = inHour * HOUR + inMin;
            
            int outHour = Integer.parseInt(time[1].split(":")[0]);
            int outMin = Integer.parseInt(time[1].split(":")[1]);
            int outTime = outHour * HOUR + outMin;
            
            hotel[inTime] += 1;
            hotel[outTime + CLEAN] -= 1;
            
        }
        
        for(int i = 1; i < hotel.length; i++) {
            hotel[i] += hotel[i-1];
            answer = Math.max(answer, hotel[i]);
        }
        
        return answer;
    }
}