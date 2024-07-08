#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    
    for(int i = 0; i < str.length(); i++) {
        char c = str[i];
        
        if(c - '0' >= 49 && c - '0' <= 74) {
            str[i] = toupper(str[i]);
        } else {
            str[i] = tolower(str[i]);
        }
    }
    
    cout << str;
    
    return 0;
}