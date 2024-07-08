#include <iostream>
#include <string>
#include <algorithm>

using std::string;
using std::cin;
using std::cout;

int main() {
	int A, B, C, D;

	cin >> A >> B >> C >> D;

	cout << abs((A + D) - (B + C));

	return 0;
}