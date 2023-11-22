class Solution {
    
    static int targetNum, answer, sum;
    
    public int solution(int[] numbers, int target) {
        
        // 정답 초기화
        answer = 0;
        
        // 다 더한 숫자 초기화
        sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        
        // 타겟 넘버 초기화
        targetNum = target;
        
        // 깊이 우선 탐색 진행, 시작 숫자는 numbers의 0번 인덱스
        // 더하기와 빼기를 진행(방문배열처럼?)
        // 전체 숫자를 다 더하고, 빼기를 dfs로 진행하면 어떨까?
        // 더한 숫자, depth, numbers 배열을 인자로 넘기기
        dfs(sum, 0, numbers);
        
        return answer;
    }
    
    static void dfs(int sum, int depth, int[] numbers) {
        // 종료조건: depth가 numbers의 길이와 같다면...
        if(depth == numbers.length) {
            // 그 때의 sum 값이 target 숫자와 일치한다면...?
            if(sum == targetNum) {
                // 정답 1 상승
                ++answer;
            }
            // 종료
            return;
        }
        // 그대로 진행하는 경우
        dfs(sum, depth+1, numbers);
        
        // 뺀 상태로 진행하는 경우 -> 그런데 이제 본인을 두 번 빼줘야함
        dfs(sum-numbers[depth]*2, depth+1, numbers);
        
    }
}