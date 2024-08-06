#include <bits/stdc++.h>

using namespace std;

double value;

int main(){
    cin >> value;
    printf("%.6f", 100.0 / ((1.609344 / 3.785411784) * value));
}