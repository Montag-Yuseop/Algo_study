#include <iostream>

using std::cin;
using std::cout;

int main() {

	long num;
	cin >> num;

	if (num == 0) {
		cout << "NO";
		return 0;
	}

	long* arr = new long[21];

	arr[0] = 1;

	for (int i = 1; i < 21; i++) {
		arr[i] = i * arr[i - 1];
	}

	for (int i = 20; i >= 0; i--) {
		if (num >= arr[i]) {
			num -= arr[i];
		}
	}

	if (num == 0) cout << "YES";
	else cout << "NO";

	return 0;
}