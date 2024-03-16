class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int tmp = 0;
        
        // n개의 병이 있다.
        // a개의 병을 주면 b개의 새 콜라를 준다
        // n개를 주면 -> 처음에 n/a * b개의 병을 준다
        // 그리고 나머지는 계속 저장해야 한다
        // 그러면 나머지 + n/a * b개의 병이 생긴다
        // 이걸 나머지가 없거나 더 안나눠질 때 까지 반복하자
        
        while(true) {
            int x = n / a;
            if(x == 0) break;
            
            int bottle = a * x; // 가져갈 병의 수
            int newBottle = b * x; // 새로 받은 병의 수
            answer += newBottle;
            
            n = n - bottle + newBottle; // 남은 병의 수
            
        }
        
        return answer;
    }
}