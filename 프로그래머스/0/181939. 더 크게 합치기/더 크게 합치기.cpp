#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int answer = 0;
    int num1 = stoi(to_string(a)+to_string(b));
    int num2 = stoi(to_string(b)+to_string(a));
    
    
    if(num1 >= num2) return num1;
    else return num2;
}