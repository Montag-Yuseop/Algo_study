#include <iostream>

using std::cin;
using std::cout;

int cnt;

int main(){
    for(int i = 0; i < 6; i++){
        char info;
        cin >> info;
        if (info == 'W') cnt++;
    }
    if(!cnt) cout << -1;
    else if(cnt >= 5) cout << 1;
    else if(cnt >= 3) cout << 2;
    else cout << 3;
}