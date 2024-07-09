#include <string>
#include <iostream>
#include <vector>

using namespace std;

string solution(string str1, string str2) {
    string answer = "";
    
    for(int i = 0; i < str1.length(); i++) {
        answer.append(str1.substr(i, 1));
        answer.append(str2.substr(i, 1));
    }
    
    return answer;
}