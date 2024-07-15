#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <map>

using namespace std;

    
// 중복값 체크할 map 생성
map<string, int> checkMap;

bool checkWord(string s1, string s2) {
    return s1[s1.length() - 1] == s2[0];
}

bool duple(string s) {
    if(checkMap.count(s) > 0) return true;
    
    ++checkMap[s];
    return false;
}

vector<int> solution(int n, vector<string> words) {
    vector<int> answer = {0, 0};
    queue<int> q;
    
    // 사용자를 q에 1부터 n까지 집어 넣음
    for(int i = 1; i <= n; i++) {
        q.push(i);
    }
    
    // 1번은 틀릴 수 없으므로
    // 맨 뒤에 입력해주자
    q.pop();
    q.push(1);
    duple(words[0]);
    
    // words의 길이만큼 순회하며 진행
    // 단 이전 글자와 비교하기 위해 처음은 생략함(index error 배제)
    for(int i = 1; i < words.size(); i++) {
        string before = words[i-1];
        string now = words[i];
        // 지금 순서
        int peopleNum = q.front();
        // 이전 단어 맨 뒷 글자와 현재 단어 맨 앞 글자가 다르면
        // 또는 중복 단어를 말했으면
        // 끝말잇기 끝
        if(!checkWord(before, now) || duple(now)) {
            answer[0] = peopleNum;
            answer[1] = i / n + 1;
            return answer;
        }
        
        q.pop();
        q.push(peopleNum);
    }

    return answer;
}