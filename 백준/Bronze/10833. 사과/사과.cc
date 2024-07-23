#include <iostream>

using std::cin;
using std::cout;

int main() {
	int n;
	cin >> n;
	int answer = 0;

	for (int i = 0; i < n; i++) {
		int student, apple;
		cin >> student >> apple;
		
		answer += (apple % student);
	}
	
	cout << answer;

	return 0;
}