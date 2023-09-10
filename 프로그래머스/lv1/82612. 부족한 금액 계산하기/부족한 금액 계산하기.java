class Solution {
    public long solution(long price, long money, long count) {
        long answer = 0;
        long temp = 0;
        
        temp = (price + (price*count)) * count/2;
        // if(count % 2 != 0) {
        //     temp -= ((price)+(price*count))/2;
        // }
        
        // System.out.println(temp);
        answer = temp - money;
        if(answer < 0) {
            return 0;
        }
        
        return answer;
    }
}