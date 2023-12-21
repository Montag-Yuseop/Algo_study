class Solution {
    public int solution(int storey) {
        int answer = 0;

        // 주어진 숫자 storey를 10의 0 ~ c승의 수 중 높은 것 부터 나눠준다
        // 2554면 1000, 16이면 10
        // 다음 숫자가 1 ~ 4면 -1 버튼, 5 ~ 9면 +1 버튼을 누르자
        
        while(storey != 0) {
            // 0이 아닌 동안 반복
            int share = storey / 10; // 현재 층을 10으로 나눈 몫
            int remain = storey % 10; // 현재 층을 10으로 나눈 나머지
            int gap = 10 - remain; // 나머지를 10에서 빼주기
            // System.out.println("share: " + share + " remain : "+ remain);
            
            if(remain ==  5) {
                if(share % 10 >= 5) {
                    share += 1;
                    answer += gap;
                } else {
                   answer += remain; 
                }
            } else if(remain > 5) {
                share += 1;
                answer += gap;
            } else answer += remain;
            
            storey = share;
            // System.out.println("answer: " + answer + " storey : "+ storey);

        }
        
        return answer;
    }
}