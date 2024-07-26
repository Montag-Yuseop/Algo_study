#include <iostream>
using namespace std;
int main(){
    long long a, b, c, x, y;
    cin >> a >> b >> c;
    x = (double)(a * b) / c;
    y = ((double)a / b) * c;
    if (x > y)
        cout << x;
    else
        cout << y;
    return 0;
}