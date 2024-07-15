#include <iostream>
#include <string>
#include <vector>
#include <stack>

using namespace std;

// 괄호 삽입 메서드
// 여는 괄호면 삽입
bool checkData(char c) {
    return c == '(' || c == '[' || c == '{';
}

// 괄호 짝 점검 메서드
bool checkPair(char c, char top) {
    if(c == ')' && top == '(') return true;
    if(c == '}' && top == '{') return true;
    if(c == ']' && top == '[') return true;
    
    return false;
}

// 괄호 점검 메서드
bool checkBracket(string s) {
    stack<int> stk;
    
    for(int i = 0; i < s.length(); i++) {
        char c = s[i];
        if(checkData(c))
            stk.push(c);
        else {
            // 닫는 괄호가 나온 경우
            // stk에 비교할 데이터가 없으면? 이미 잘못된 데이터
            if(stk.empty()) return false;
            
            // stk에 데이터가 있으면
            // c와 데이터를 비교 해보기
            if(checkPair(c, stk.top())) stk.pop();
            else return false;
        }
        
    }
    // 괄호가 모두 빠져나가 stk이 empty라면 true아니면 false
    if(!stk.empty()) return false;
    
    return true;
}

int solution(string s) {
    int answer = 0;

    // 괄호를 회전해야 하므로, length - 1만큼까지 돌린다음 괄호체크
    for(int i = 0; i < s.size(); i++) {
        string data = s.substr(i, s.size()) + s.substr(0, i);
        
        // data를 돌면서 괄호를 점검하면 됨
        // 괄호 점검이 true면 answer을 ++
        if(checkBracket(data)) answer++;
    }

    
    return answer;
}