class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        
        // 반복문 돌면서 약수의 수를 구함
        for(int i = 2; i <= number; i++) {
            int cnt = buyWeapon(i);
            
            if(cnt > limit) {
                answer += power;
            } else {
                answer += cnt;
            }
            
        }
        
        return answer;
    }
    
    static int buyWeapon(int num) {
        int cnt = 0;
        for(int i = 1; i <= (int) Math.sqrt(num); i++) {
            if(i * i == num) cnt++;
            
            else if(num % i == 0) {
                cnt += 2;
            }
        }
        return cnt;
        
    }
    
}