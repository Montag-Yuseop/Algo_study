#include <bits/stdc++.h>

using namespace std;

int a[3], b[3], s, e;

int main(){
    scanf("%d : %d : %d", &a[0], &a[1], &a[2]);
    scanf("%d : %d : %d", &b[0], &b[1], &b[2]);
    
    s = a[2] + a[1] * 60 + a[0] * 3600;
    e = b[2] + b[1] * 60 + b[0] * 3600;

    if (s > e) cout << 24 * 3600 - s + e;
    
    else cout << e - s;
}