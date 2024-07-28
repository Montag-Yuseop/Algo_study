#include<iostream>

using std::cin;
using std::cout;
 
int main(){
    int t, temp, answer = 0;
    cin >> t;
    for (int i = 0; i < 5; i++){
        cin >> temp;
        if(t == temp)
            answer += 1;
    }
    cout << answer;
    
    return 0;
}