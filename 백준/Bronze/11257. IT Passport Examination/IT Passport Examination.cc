#include <bits/stdc++.h>

using namespace std;

int tc, num, a, b, c, sum;
int main(){
  cin >> tc;
  while(tc--){
    cin >> num >> a >> b >> c;
    sum = a + b + c;
    cout << num << ' ' << sum << ' ';
    if(sum >= 55 && a >= 11 && b >= 8 && c >= 12) cout << "PASS\n";
    else cout << "FAIL\n";
  }
}