#include <iostream>
#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer(prices.size());
    
    // stack 내에 vector 값을 삽입한다
    // 0번은 들어온 시점(index) 1번은 price(value)로 사용한다
    stack<vector<int>> stk;
    
    for(int i = 0; i < prices.size(); i++) {
        vector<int> now;
        now.push_back(i);
        now.push_back(prices[i]);
        
        // 비어있거나, 현재 price의 값이 같거나 크다면 그대로 삽입한다
        // 현재 값이 같거나 크다는 것은 이전 것이 떨어지지 않았다는 의미
        if(stk.empty() || stk.top()[1] <= prices[i]) stk.push(now);
        
        // 비어있지 않으면서, 현재 값이 더 작다면
        // 현재 값보다 컸던 이전 값들은 모두 해당 지점에서 떨어진 것과 마찬가지
        else {
            // 이전 값이 더 크거나 빌 때까지 빼버리면서
            // 떨어진 위치를 정답 배열에 입력하자
            while(!stk.empty() && stk.top()[1] > prices[i]) {
                vector<int> before = stk.top();
                answer[before[0]] = i - before[0];
                stk.pop();
            }
            
            // 다 빼줬으면 now 데이터를 삽입
            stk.push(now);
        }

    }
    
    // 전체 탐색이 끝나면, 스택에 남은 애들을 최종 인덱스에서 빼준다
    // 여기 남은 애들은 처음부터 마지막까지 주식 가격이 떨어지지 않은 애들
    while(!stk.empty()) {
        vector<int> now = stk.top();
        answer[now[0]] = (prices.size() - 1) - now[0];
        stk.pop();
    }
    
    return answer;
}