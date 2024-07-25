#include <iostream>
using namespace std;

int main(){
    int n, m, k;
    cin >> n >> m >> k;
    int ans =  min(m, k) + min(n-m, n-k);
    cout << ans;
    return 0;
}